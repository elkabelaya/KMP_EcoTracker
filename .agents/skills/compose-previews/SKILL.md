---
name: compose-previews
description: Используй этот скилл при создании, редактировании или рефакторинге Jetpack Compose @Preview функций и фейковых тестовых данных (Preview objects) в проекте EcoTracker.
---

# Preview Pattern (EcoTracker)

Фейк-данные для превью живут в отдельных файлах в пакете `ui/preview/`:

```text
ui/preview/
├── Preview.kt            ← object Preview (пустой)
├── HabitPreview.kt       ← val Preview.Habit: Habit get() = ...
├── AchievementPreview.kt ← val Preview.Achievement: Achievement get() = ...
└── ...
```

## Правила создания фейк-данных
Каждый файл `XxxPreview.kt` определяет extension property на `Preview`:

```kotlin
package ru.elkabelaya.ecotracker.ui.preview

import Preview
import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.domain.model.HabitCategory

val Preview.Habit: Habit
    get() = Habit("1", "HabitPreview", HabitCategory.TRANSPORT)
```

## Правила оформления компонента
В UI-компоненте превью должно использовать аннотацию `@AppPreview` и обертку темы:

```kotlin
@AppPreview
@Composable
private fun XxxComponentPreview() {
    EcoTrackTheme {
        // Вызов компонента с данными из Preview.Xxx
    }
}
```
