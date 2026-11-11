package ru.elkabelaya.ecotracker.data.formatters

typealias DateFormat = String
object DateFormats {
    const val DDMMYYYY: DateFormat = "dd.mm.yyyy"
}

interface DateFormatter {
    fun format(milliseconds: Long, format: DateFormat): String
}
