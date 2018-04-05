package toolgamecorporation.worldcupschedule.presentations.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_standing_layout.view.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.FlagUtils
import toolgamecorporation.worldcupschedule.data.entity.TeamSortEntity

/**
 * Created by FRAMGIA\pham.dinh.tuan on 27/03/2018.
 */
class StandingAdapter(var context: Context, var teams: ArrayList<Any>) : RecyclerView.Adapter<StandingAdapter.StandingViewHolder>() {
    var inflater: LayoutInflater? = null

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {
        return teams.size
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StandingAdapter.StandingViewHolder {
        return StandingViewHolder(inflater!!.inflate(R.layout.item_standing_layout, parent, false))
    }

    override fun onBindViewHolder(holder: StandingAdapter.StandingViewHolder?, position: Int) {
        holder?.bindata(context, teams[position])
    }

    class StandingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindata(context: Context, data: Any) {
            when (data) {
                is String -> {
                    itemView.viewLeft.visibility = View.GONE
                    itemView.tvGroup.visibility = View.VISIBLE
                    itemView.tvGroup.text = "Team"
                    itemView.tvTotalMatch.text = "GP"
                    itemView.tvMatchW.text = "W"
                    itemView.tvMatchD.text = "D"
                    itemView.tvMatchL.text = "L"
                    itemView.tvRecordGoal.text = "GF"
                    itemView.tvAllowGoal.text = "GA"
                    itemView.tvGoalDiff.text = "GD"
                    itemView.tvPoint.text = "Pts"
                    itemView.tvGroup.setTextColor(context.resources.getColor(R.color.tab_text))
                    itemView.tvTotalMatch.setTextColor(context.resources.getColor(R.color.tab_text))
                    itemView.tvMatchW.setTextColor(context.resources.getColor(R.color.tab_text))
                    itemView.tvMatchD.setTextColor(context.resources.getColor(R.color.tab_text))
                    itemView.tvMatchL.setTextColor(context.resources.getColor(R.color.tab_text))
                    itemView.tvRecordGoal.setTextColor(context.resources.getColor(R.color.tab_text))
                    itemView.tvAllowGoal.setTextColor(context.resources.getColor(R.color.tab_text))
                    itemView.tvGoalDiff.setTextColor(context.resources.getColor(R.color.tab_text))
                    itemView.tvPoint.setTextColor(context.resources.getColor(R.color.tab_text))
                }
                is TeamSortEntity -> {
                    itemView.viewLeft.visibility = View.VISIBLE
                    itemView.tvGroup.visibility = View.GONE
                    itemView.imgAvatar.setImageResource(FlagUtils.getFlagRectangle(context, data.name!!))
                    itemView.tvName.text = data.name!!
                    itemView.tvTotalMatch.text = data.matches.toString()
                    itemView.tvMatchW.text = data.matchW.toString()
                    itemView.tvMatchD.text = data.matchD.toString()
                    itemView.tvMatchL.text = data.matchL.toString()
                    itemView.tvRecordGoal.text = data.recordGoals.toString()
                    itemView.tvAllowGoal.text = data.allowGoals.toString()
                    itemView.tvGoalDiff.text = data.goalDifference.toString()
                    itemView.tvPoint.text = data.point.toString()

                    itemView.tvName.setTextColor(context.resources.getColor(R.color.white))
                    itemView.tvTotalMatch.setTextColor(context.resources.getColor(R.color.tabtextselect))
                    itemView.tvMatchW.setTextColor(context.resources.getColor(R.color.tabtextselect))
                    itemView.tvMatchD.setTextColor(context.resources.getColor(R.color.tabtextselect))
                    itemView.tvMatchL.setTextColor(context.resources.getColor(R.color.tabtextselect))
                    itemView.tvRecordGoal.setTextColor(context.resources.getColor(R.color.tabtextselect))
                    itemView.tvAllowGoal.setTextColor(context.resources.getColor(R.color.tabtextselect))
                    itemView.tvGoalDiff.setTextColor(context.resources.getColor(R.color.tabtextselect))
                    itemView.tvPoint.setTextColor(context.resources.getColor(R.color.tabtextselect))
                }
            }
        }
    }

}