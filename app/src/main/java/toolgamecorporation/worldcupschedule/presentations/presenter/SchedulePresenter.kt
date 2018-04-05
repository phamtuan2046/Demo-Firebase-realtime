package toolgamecorporation.worldcupschedule.presentations.presenter

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import toolgamecorporation.worldcupschedule.common.TimeUtils
import toolgamecorporation.worldcupschedule.data.models.Schedule
import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import toolgamecorporation.worldcupschedule.data.entity.MatchEntity
import toolgamecorporation.worldcupschedule.presentations.views.ScheduleView


/**
 * Created by Dell on 3/24/2018.
 */
class SchedulePresenter(stage: String, var view: ScheduleView) {
    private var mDatabase: DatabaseReference? = null
    private var matches = ArrayList<MatchEntity>()
    private var mSchedule = ArrayList<Schedule>()

    init {
        mDatabase = FirebaseDatabase.getInstance().reference.child(stage)
    }

    fun getSchedule() {
        view.showProgress(true)
        matches.clear()
        mDatabase?.addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (snapshot in dataSnapshot.children) {
                            var data = snapshot.getValue(MatchEntity::class.java) as MatchEntity
                            matches.add(data)
                        }
                        view.onLoadedSchedule(getdata(matches))
                        view.showProgress(false)
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        Log.d(TAG, "Value is: datasnapshot")
                        view.showProgress(false)
                    }
                })
    }

    fun getdata(matches: ArrayList<MatchEntity>): ArrayList<Schedule> {
        mSchedule.clear()
        if (matches.isEmpty()) return mSchedule
//        var dates = TimeUtils.getDaysBetweenDates(matches[0].time!!, matches[matches.size - 1].time!!)
        var dates = TimeUtils.getDaysBetweenDates(TimeUtils.pareDateFromString(matches[0].time!!, TimeUtils.ISO_8601_DATE_TIME_FORMAT_SEND)!!, TimeUtils.pareDateFromString(matches[matches.size - 1].time!!, TimeUtils.ISO_8601_DATE_TIME_FORMAT_SEND)!!)
        for (date in dates) {
            var schedule = Schedule()
            var list = matches.filter { matchEntity ->
                TimeUtils.getDateStrWith(TimeUtils.pareDateFromString(matchEntity.time!!, TimeUtils.ISO_8601_DATE_TIME_FORMAT_SEND)!!, TimeUtils.DATE_FORMAT) == TimeUtils.getDateStrWith(date, TimeUtils.DATE_FORMAT)
            }
            if (list.isNotEmpty()) {
                schedule.date = date
                schedule.matchs.addAll(list)
                mSchedule.add(schedule)
            }
        }
        Log.d("getDaysBetweenDates", " " + mSchedule.size)
        return mSchedule
    }

}