package ru.elkabelaya.ecotracker.ui.preview

import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.domain.model.HabitCategory

val Preview.Habit: Habit
    get() = Habit("1", "HabitPreview", HabitCategory.TRANSPORT)
