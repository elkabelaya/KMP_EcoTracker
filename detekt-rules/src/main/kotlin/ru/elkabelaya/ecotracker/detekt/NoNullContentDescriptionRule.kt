package ru.elkabelaya.ecotracker.detekt

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.psi.KtConstantExpression
import org.jetbrains.kotlin.psi.KtValueArgument

class NoNullContentDescriptionRule(config: Config = Config.empty) : Rule(config) {

    override val issue = Issue(
            id = "NoNullContentDescription",
            severity = Severity.Defect,
            description = "Параметр contentDescription не должен быть равен null. Укажите описание для доступности (Accessibility).",
            debt = Debt.FIVE_MINS
    )

    override fun visitArgument(argument: KtValueArgument) {
        super.visitArgument(argument)

        // 1. Проверяем, что имя передаваемого аргумента — contentDescription
        val argName = argument.getArgumentName()?.asName?.asString()
        if (argName != "contentDescription") return

                // 2. Проверяем, что значение аргумента является константой null
                val expression = argument.getArgumentExpression()
        val isNullLiteral = expression is KtConstantExpression &&
        expression.node.elementType == KtNodeTypes.NULL

        if (isNullLiteral) {
            report(
                    CodeSmell(
                            issue = issue,
                            entity = Entity.from(argument),
                            message = "contentDescription не может быть выставлен в null. Передайте локализованное описание через stringResource()."
                    )
            )
        }
    }
}

