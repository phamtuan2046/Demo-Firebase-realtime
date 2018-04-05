package toolgamecorporation.worldcupschedule.presentations.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_schedule_layout.view.*
import kotlinx.android.synthetic.main.match_first_layout.view.*
import kotlinx.android.synthetic.main.match_second_layout.view.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.FlagUtils
import toolgamecorporation.worldcupschedule.common.TimeUtils
import toolgamecorporation.worldcupschedule.data.models.Schedule

/**
 * Created by FRAMGIA\pham.dinh.tuan on 23/03/2018.
 */
class ScheduleAdapter(var context: Context, var schedule: ArrayList<Schedule>) : RecyclerView.Adapter<ScheduleAdapter.MatchViewHolder>() {
    var inflater: LayoutInflater? = null

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MatchViewHolder {
        return MatchViewHolder(inflater!!.inflate(R.layout.item_schedule_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MatchViewHolder?, position: Int) {
        holder?.bindata(context, schedule[position])
    }

    override fun getItemCount(): Int {
        return schedule.size
    }

    class MatchViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var matchAdapter: MatchAdapter? = null
        fun bindata(context: Context, schedule: Schedule) {
            // first match
            itemView.tvDay.text = TimeUtils.getDateStrWith(schedule.date, TimeUtils.ISO_DATETIME_TIME_ZONE_FORMAT)
            matchAdapter = null
            matchAdapter = MatchAdapter(context,schedule.matchs)
            itemView.rcvMatch.adapter = matchAdapter
        }
    }
}