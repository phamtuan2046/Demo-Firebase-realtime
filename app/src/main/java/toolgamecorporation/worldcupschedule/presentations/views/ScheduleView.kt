package toolgamecorporation.worldcupschedule.presentations.views

import toolgamecorporation.worldcupschedule.data.models.Schedule

/**
 * Created by Dell on 3/24/2018.
 */
interface ScheduleView {
    fun onLoadedSchedule(schedule: ArrayList<Schedule>)

    fun showProgress(show:Boolean)
}