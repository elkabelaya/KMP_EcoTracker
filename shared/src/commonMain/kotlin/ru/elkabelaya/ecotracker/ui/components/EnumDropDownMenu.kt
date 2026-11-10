package ru.elkabelaya.ecotracker.ui.components
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.type
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.domain.model.HabitCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : Enum<T>> EnumDropdownMenu(
    allItems: List<T>,                      // Передаем список всех элементов (через YourEnum.entries)
    selectedItem: T,                        // Текущий выбранный элемент
    onItemSelected: (T) -> Unit,            // Колбэк при выборе
    itemToText: (T) -> String,              // Преобразование Enum в текст
    modifier: Modifier = Modifier,
    label: String = "Выберите значение",
    initialExpanded: Boolean = false
) {
    var expanded by remember { mutableStateOf(initialExpanded) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = modifier.fillMaxWidth().padding(16.dp)
    ) {
        OutlinedTextField(
            value = itemToText(selectedItem),
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
            modifier = Modifier
                .menuAnchor(type = ExposedDropdownMenuAnchorType.PrimaryNotEditable, enabled = true)
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            allItems.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = itemToText(item)) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}


@Preview
@Composable
private fun EnumDropdownMenuPreview(){
    MaterialTheme {
        EnumDropdownMenu(
            HabitCategory.entries,
            HabitCategory.TRANSPORT,
            {},
            { return@EnumDropdownMenu "TEST" }
        )
    }
}