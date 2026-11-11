package ru.elkabelaya.ecotracker.detekt

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtCallExpression

class RequireStyleInTextRule(config: Config = Config.empty) : Rule(config) {

    override val issue = Issue(
        id = "RequireStyleInText",
        severity = Severity.Defect,
        description = "Компонент Text должен всегда вызываться с явным указанием параметра style.",
        debt = Debt.FIVE_MINS
    )

    override fun visitCallExpression(expression: KtCallExpression) {
        super.visitCallExpression(expression)

        val calleeName = expression.calleeExpression?.text
        if (calleeName != "Text") return

        val hasStyleArg = expression.valueArguments.any { argument ->
            argument.getArgumentName()?.asName?.asString() == "style"
        }

        if (!hasStyleArg) {
            report(
                CodeSmell(
                    issue = issue,
                    entity = Entity.from(expression),
                    message = "Вызов Text() должен содержать явный параметр style."
                )
            )
        }
    }
}
