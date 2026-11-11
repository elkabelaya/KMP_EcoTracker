package ru.elkabelaya.ecotracker.detekt

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtAnnotationEntry
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtStringTemplateExpression
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType

class NoHardcodedStringsInComposableRule(config: Config = Config.empty) : Rule(config) {

    override val issue = Issue(
        id = "NoHardcodedStringsInComposable",
        severity = Severity.Defect,
        description = "Внутри @Composable-функций запрещено использовать хардкод строк. Используйте Res.string.",
        debt = Debt.FIVE_MINS
    )

    // Имена вызовов, внутри которых строки разрешены (например, логирование или контент-дескрипшены при необходимости)
    private val ignoredCallNames = setOf("Log", "println", "print", "require", "check", "error")

    override fun visitStringTemplateExpression(expression: KtStringTemplateExpression) {
        super.visitStringTemplateExpression(expression)

        // 1. Игнорируем пустые строки "" и строки, состоящие только из пробелов
        val rawText = expression.entries.joinToString("") { it.text }
        if (rawText.isBlank()) return

        // 2. Игнорируем строки внутри аннотаций (например, @Suppress("..."))
        if (expression.getParentOfType<KtAnnotationEntry>(strict = true) != null) return

        // 3. Проверяем, находится ли строка внутри функции с аннотацией @Composable
        val enclosingFunction = expression.getParentOfType<KtNamedFunction>(strict = true) ?: return
        val isComposable = enclosingFunction.annotationEntries.any { annotation ->
            annotation.shortName?.asString() == "Composable"
        }
        if (!isComposable) return

        // 4. Игнорируем функции @Preview (в превью тестовые строки обычно допустимы)
        val isPreview = enclosingFunction.annotationEntries.any { annotation ->
            annotation.shortName?.asString() == "Preview"
        }
        if (isPreview) return

        // 5. Игнорируем разрешенные служебные вызовы (например, println("debug"))
        val parentCall = expression.getParentOfType<KtCallExpression>(strict = true)
        val callName = parentCall?.calleeExpression?.text
        if (callName in ignoredCallNames) return

        report(
            CodeSmell(
                issue = issue,
                entity = Entity.from(expression),
                message = "Найдена захардкоженная строка \"${expression.text}\". Вынесите её в composeResources/values/strings.xml."
            )
        )
    }
}
