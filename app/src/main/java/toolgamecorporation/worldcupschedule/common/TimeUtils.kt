package toolgamecorporation.worldcupschedule.common

/**
 * Created by Dell on 3/22/2018.
 */

import android.text.format.Time
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap


object TimeUtils {

    val TIME_FORMAT = "HH:mm"
    val ONLY_DATE_FORMAT = "dd日"
    val MONTH_DATE_FORMAT = "MM月dd日"
    val DATE_FORMAT = "yyyy-MM-dd"
    val ISO_DATETIME_TIME_ZONE_FORMAT = "E yyyy-MM-dd"
    val ISO_8601_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"
    val ISO_8601_DATE_TIME_FORMAT_RECEIVE = "yyyy-MM-dd HH:mm"
    val ISO_8601_DATE_TIME_FORMAT_SEND = "yyyy-MM-dd HH:mm Z"
    val SUNDAY = 0
    val MONDAY = 1

    private val cacheDateFormat: HashMap<String, SimpleDateFormat> by lazy {
        HashMap<String, SimpleDateFormat>()
    }

    fun getDateFormat(pattern: String = ISO_8601_DATE_TIME_FORMAT): SimpleDateFormat {
        if (cacheDateFormat[pattern] == null) {
            val format = SimpleDateFormat(pattern, Locale.getDefault())
//            format.isLenient = false
            cacheDateFormat[pattern] = format
        }

        return cacheDateFormat[pattern]!!
    }

    fun getWeekSinceJulianDay(calendar: Calendar, firstDayOfWeek: Int): Int = getWeeksSinceEpochFromJulianDay(getJulianDay(calendar), firstDayOfWeek)

    fun getDaysOfWeek(week: Int, currentWeek: Int, daysOfWeek: Array<Date>, firstDayOfWeek: Int): Array<Date> {
        val calendar = Calendar.getInstance()
        if (firstDayOfWeek == MONDAY) {
            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                calendar.add(Calendar.DAY_OF_MONTH, -1)
            }
        } else {
            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                calendar.add(Calendar.DAY_OF_MONTH, -1)
            }
        }

        val betweenNumber = week - currentWeek

        calendar.add(Calendar.DAY_OF_MONTH, betweenNumber * Calendar.DAY_OF_WEEK)

        for (i in 0..6) {
            daysOfWeek[i] = calendar.time
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        return daysOfWeek
    }

    private fun getJulianDay(calendar: Calendar): Int {
        val month = calendar.get(Calendar.MONTH) + 1
        val a = (14 - month) / 12
        val y = calendar.get(Calendar.YEAR) + 4800 - a
        val m = month + 12 * a - 3

        return calendar.get(Calendar.DATE) + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400 - 32045
    }

    private fun getWeeksSinceEpochFromJulianDay(julianDay: Int, firstDayOfWeek: Int): Int {
        var diff = Calendar.WEDNESDAY - firstDayOfWeek
        if (diff < 0) {
            diff += 7
        }

        /**
         * 2440588: The Julian day of the epoch, that is, January 1, 1970 on the Gregorian
         * calendar.
         */
        val refDay = 2440588 - diff
        return (julianDay - refDay) / 7
    }

    fun getDateNumber(calendar: Calendar, date: Date): String {
        calendar.time = date
        val dateNumber = calendar.get(Calendar.DATE)
        if (dateNumber == 1) {
            return getDateFormat("M/d").format(date)
        }
        return dateNumber.toString()
    }

    /**
     * Calculate and return a list of days in a month (both days of previous and next month which is in week overlap the current month)
     *
     * @param firstDate The first date of the month
     * @param firstDayOfWeek Value to determine which the first day of week is (MONDAY: 0, SUNDAY: 1)
     * @return a list of days
     */
    fun getActualWeeksOfMonth(firstDate: Calendar, firstDayOfWeek: Int): ArrayList<Calendar> {
        val listCalendar = java.util.ArrayList<Calendar>()

        val temp = firstDate.clone() as Calendar
        if (firstDayOfWeek == MONDAY) {
            temp.firstDayOfWeek = Calendar.MONDAY
        } else {
            temp.firstDayOfWeek = Calendar.SUNDAY
        }

        val numberOfWeek = temp.getActualMaximum(Calendar.WEEK_OF_MONTH)
        if (firstDayOfWeek == MONDAY) {
            while (temp.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                temp.add(Calendar.DAY_OF_MONTH, -1)
            }
        } else {
            while (temp.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                temp.add(Calendar.DAY_OF_MONTH, -1)
            }
        }
        for (i in 0 until 7 * numberOfWeek) {
            listCalendar.add(temp.clone() as Calendar)
            temp.add(Calendar.DATE, 1)
        }

        return listCalendar
    }

    fun pareDateFromString(str: String, dateFormat: String): Date? {
        try {
            var dateformat = SimpleDateFormat(dateFormat)
            return dateformat.parse(str)
        } catch (e: Exception) {
            return null
        }
    }

    fun getActualNumberDayOfMonth(calendar: Calendar, firstDayOfWeek: Int): Int {
        val temp = calendar.clone() as Calendar
        if (firstDayOfWeek == MONDAY) {
            temp.firstDayOfWeek = Calendar.MONDAY
        } else {
            temp.firstDayOfWeek = Calendar.SUNDAY
        }

        val numberOfWeek = temp.getActualMaximum(Calendar.WEEK_OF_MONTH)

        return 7 * numberOfWeek
    }

    /**
     * Returns a calendar instance at the start of this day
     *
     * @return the calendar instance
     */
    fun today(): Calendar {
        val today = Calendar.getInstance()
        today.set(Calendar.HOUR_OF_DAY, 0)
        today.set(Calendar.MINUTE, 0)
        today.set(Calendar.SECOND, 0)
        today.set(Calendar.MILLISECOND, 0)
        return today
    }

    /**
     * Returns the day of week.
     *
     * @param date the calendar instance
     * @return the day of week
     */
    fun getDayOfWeek(date: Calendar): String {
        return formatDateTime(date, "EEE")
    }

    /**
     * Returns the day of month.
     *
     * @param date the calendar instance
     * @return the day of month
     */
    fun getDayOfMonth(date: Calendar): String {
        return formatDateTime(date, "d")
    }

    /**
     * Formats a Calendar into a date/time string.
     *
     * @param date    the calendar instance
     * @param pattern the pattern describing the date and time format
     * @return the formatted time string
     */
    private fun formatDateTime(date: Calendar, pattern: String): String {
        return try {
            val sdf = TimeUtils.getDateFormat(pattern)
            sdf.format(date.time)
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }

    }

    /**
     * Return the number of days between two calendar dates.
     *
     * @param c1               the start time as the calendar instance
     * @param c2               the end time as the calendar instance
     * @param shouldPlusOneDay if true, then the result will be plus one day
     * @return the number of days
     */
    @JvmOverloads
    fun daysBetween(c1: Calendar, c2: Calendar, shouldPlusOneDay: Boolean = true): Int {
        c1.set(Calendar.MILLISECOND, 0)
        c2.set(Calendar.MILLISECOND, 0)
        val startTime = Time()
        startTime.set(c1.timeInMillis)
        // The first millisecond of the next day is still the same day.
        val endTime = Time()
        endTime.set(c2.timeInMillis - 1)
        return (if (shouldPlusOneDay) 1 else 0) + Time.getJulianDay(endTime.toMillis(true), endTime.gmtoff) - Time.getJulianDay(startTime.toMillis(true), startTime.gmtoff)
    }

    /**
     * Convert a date into a double that will be used to reference when you're loading data.
     *
     * All periods that have the same integer part, define one period. Dates that are later in time
     * should have a greater return value.
     *
     * @param instance the date
     * @return The period index in which the date falls (floating point number).
     */
    fun toWeekViewPeriodIndex(instance: Calendar): Double {
        return (instance.get(Calendar.YEAR) * 12).toDouble() + instance.get(Calendar.MONTH).toDouble() + (instance.get(Calendar.DAY_OF_MONTH) - 1) / 30.0
    }


    fun getYearMonthDay(date: Date): Triple<Int, Int, Int> {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return Triple(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH))
    }

    fun getDateFromYearMonthDay(year: Int, month: Int, day: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, day)
        return calendar.time
    }


    fun getMonthDateWeekday(date: Date): Triple<Int, Int, String> {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val weekday = getDateFormat("EEE").format(date)
        return Triple(month, day, weekday)
    }


    fun getFirstDayOfWeek(currentTime: Date?, firstDayOfWeek: Int): Calendar {
        val calendar = Calendar.getInstance()
        calendar.time = currentTime

        if (firstDayOfWeek == MONDAY) {
            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                calendar.add(Calendar.DAY_OF_MONTH, -1)
            }
        } else {
            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                calendar.add(Calendar.DAY_OF_MONTH, -1)
            }
        }

        return calendar
    }

    fun getFirstDayOfMonth(currentTime: Date?): Calendar {
        val calendar = Calendar.getInstance()
        calendar.time = currentTime
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        return calendar
    }

    fun getDateStrWith(date: Date?, pattern: String): String {
        var dateStr = ""
        if (date != null) {
            val dateFormat: DateFormat = getDateFormat(pattern)
            dateStr = dateFormat.format(date)
        }
        return dateStr
    }
    fun getDaysBetweenDates(startdate: Date, enddate: Date): List<Date> {
        val dates = ArrayList<Date>()
        val calendar = GregorianCalendar()
        calendar.time = startdate
        var cl = Calendar.getInstance()
        cl.time = enddate
        cl.add(Calendar.DATE, 1)
        while (calendar.time.before(cl.time)) {
            val result = calendar.time
            dates.add(result)
            calendar.add(Calendar.DATE, 1)
        }
        return dates
    }
    fun getBeginDay(date:Date):Date{
        var cal = Calendar.getInstance()
        cal.time = date
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.time
    }
    fun getFinishDay(date:Date):Date{
        var cal = Calendar.getInstance()
        cal.time = date
        cal.set(Calendar.HOUR_OF_DAY, 23)
        cal.set(Calendar.MINUTE, 59)
        cal.set(Calendar.SECOND, 59)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.time
    }
}


fun Date.getDayOfMonth(): Int {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return calendar.get(Calendar.DAY_OF_MONTH)
}

fun Date.getWeekOfMonth(): Int {
    val calendar = Calendar.getInstance()
    calendar.time = this
    val weekOfMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)//#3954
    return if (weekOfMonth == 5) -1 else weekOfMonth
}

/**
 * Check if `time` is in `x` days ago or not
 *
 * @param time The date need to check
 * @param x Number of days ago
 */
fun isInXDaysAgo(time: Date, x: Int): Boolean {
    val diff = System.currentTimeMillis() - time.time

    return diff <= 3_600_000 * 24 * x
}

/**
 * Checks if two times are on the same day.
 *
 * @param calendar The second day.
 * @return Whether the times are on the same day.
 */
fun Calendar.isTheSameDay(calendar: Calendar): Boolean {
    return this.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
            && this.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR)
}

/**
 * Get distance in month between two days
 */
operator fun Calendar.minus(other: Calendar): Int {
    return 12 * (this.get(Calendar.YEAR) - other.get(Calendar.YEAR)) + (this.get(Calendar.MONTH) - other.get(Calendar.MONTH))
}

fun Calendar.isTheSameWeek(calendar: Calendar?): Boolean {
    if (calendar == null) {
        return false
    }

    return this.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
            && this.get(Calendar.WEEK_OF_YEAR) == calendar.get(Calendar.WEEK_OF_YEAR)
}

