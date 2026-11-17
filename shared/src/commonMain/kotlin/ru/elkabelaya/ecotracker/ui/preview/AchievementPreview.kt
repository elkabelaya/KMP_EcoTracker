package ru.elkabelaya.ecotracker.ui.preview

import ru.elkabelaya.ecotracker.domain.model.Achievement

val Preview.Achievement: Achievement
    get() = Achievement("1", "Эко-новичок", "Выполнил 5 привычек", isUnlocked = false, progress = 0.6f)

val Preview.AchievementUnlocked: Achievement
    get() = Achievement("2", "Зелёная неделя", "7 дней подряд", isUnlocked = true, progress = 1f)
