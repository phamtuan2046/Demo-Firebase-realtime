package toolgamecorporation.worldcupschedule.presentations.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.match_first_layout.view.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.FlagUtils
import toolgamecorporation.worldcupschedule.common.TimeUtils
import toolgamecorporation.worldcupschedule.data.entity.MatchEntity

/**
 * Created by Dell on 3/25/2018.
 */
class MatchAdapter(var context: Context, var matches: ArrayList<MatchEntity>) : RecyclerView.Adapter<MatchAdapter.MatchHolder>() {
    var inflater: LayoutInflater? = null

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: MatchHolder?, position: Int) {
        if (position == matches.size - 1) holder?.showlinebottom(false)
        else holder?.showlinebottom(true)
        holder?.bindata(context, matches[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MatchHolder {
        return MatchHolder(inflater!!.inflate(R.layout.match_first_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    class MatchHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bindata(context: Context, match: MatchEntity) {
            itemView.tvMatchNumber.text = "(" + match.group +")"
            var idImage1 = FlagUtils.getFlag(context, match.teams[0].name!!)
            if (idImage1 != -1)
                itemView.flagLeft.setImageResource(idImage1)
            else
                itemView.flagLeft.setImageResource(R.drawable.default_plain_red)// chưa xác định được đội
            itemView.tvNameCountryLeft.text = match.teams[0].name!!
            if (match.teams[0].numberGoalar != null) {
                var tiso = match.teams[0].numberGoalar.toString() + " : " + match.teams[1].numberGoalar.toString()
                itemView.tvDetail.text = tiso
            } else {
                itemView.tvDetail.text = TimeUtils.getDateStrWith(TimeUtils.pareDateFromString(match.time!!, TimeUtils.ISO_8601_DATE_TIME_FORMAT_SEND), TimeUtils.TIME_FORMAT)
            }
            var idImage2 = FlagUtils.getFlag(context, match.teams[1].name!!)
            if (idImage2 != -1)
                itemView.flagRight.setImageResource(idImage2)
            else
                itemView.flagRight.setImageResource(R.drawable.default_white)
            itemView.tvNameCountryRight.text = match.teams[1].name!!
            itemView.tvStadium.text = match.stadium
        }

        fun showlinebottom(show: Boolean) {
            itemView.lnBottom.visibility = if (show) View.VISIBLE else View.GONE
        }
    }
}