package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * EcoTracker text field with floating label, background and border.
 *
 * Figma: `EcoTrack / Forms / Field`
 * - 338 wide, radius 12 dp
 * - Light: bg #FFFFFF, border #E0E4E8, label #9E9E9E (10 sp SemiBold, uppercase)
 * - Dark:  bg #1E1E1E, border #303030
 * - Value: onSurfaceVariant when empty, onSurface when filled
 *
 * @param label shown above input, auto-uppercased.
 * @param isPasswordField masks input with dots.
 * @param trailingIcon optional right-side icon (e.g. show/hide password).
 */
@Composable
fun EcoTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isPasswordField: Boolean = false,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: (() -> Unit)? = null,
) {
    val bgColor = MaterialTheme.colorScheme.surface
    val borderColor = MaterialTheme.colorScheme.outline
    val labelColor = MaterialTheme.colorScheme.onSurfaceVariant
    val valueColor = if (value.isEmpty()) labelColor else MaterialTheme.colorScheme.onSurface

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(bgColor, RoundedCornerShape(Dimens.Radius.m))
    ) {
        // Label
        Text(
            text = label.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            color = labelColor,
            modifier = Modifier.padding(
                start = Dimens.Paddings.m,
                end = Dimens.Paddings.m,
                top = Dimens.Paddings.s,
                bottom = 4.dp
            )
        )

        // Input
        BasicTextField(
            value = value,
            onValueChange = { if (!readOnly) onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = Dimens.Paddings.m,
                    end = if (trailingIcon != null) Dimens.Paddings.s else Dimens.Paddings.m,
                    bottom = Dimens.Paddings.s
                ),
            textStyle = MaterialTheme.typography.bodyMedium.copy(color = valueColor),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
            singleLine = singleLine,
            readOnly = readOnly,
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    innerTextField
                    if (trailingIcon != null) {
                        Spacer(Modifier.width(Dimens.Paddings.s))
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = null,
                            tint = labelColor,
                            modifier = Modifier
                                .size(24.dp)
                                .then(
                                    if (onTrailingIconClick != null) {
                                        Modifier.clickable { onTrailingIconClick() }
                                    } else {
                                        Modifier
                                    }
                                )
                        )
                    }
                }
            }
        )
    }

    // Bottom border line
    Spacer(
        Modifier
            .fillMaxWidth()
            .height(Dimens.Stroke.thin)
            .background(
                color = borderColor,
                shape = RoundedCornerShape(
                    bottomStart = Dimens.Radius.m,
                    bottomEnd = Dimens.Radius.m
                )
            )
    )
}

@AppPreview
@Composable
private fun EcoTextFieldPreview() {
    EcoTrackTheme {
        Column {
            EcoTextField(label = "Email", value = "user@example.com", onValueChange = {})
            Spacer(Modifier.height(12.dp))
            EcoTextField(label = "Пароль", value = "", onValueChange = {}, isPasswordField = true)
        }
    }
}
