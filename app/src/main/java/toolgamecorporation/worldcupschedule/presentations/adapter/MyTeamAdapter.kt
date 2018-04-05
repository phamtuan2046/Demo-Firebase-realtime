package toolgamecorporation.worldcupschedule.presentations.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_team.view.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.FlagUtils

/**
 * Created by FRAMGIA\pham.dinh.tuan on 29/03/2018.
 */
class MyTeamAdapter(var context: Context, var names: ArrayList<String>, var onclcikItem: (index: Int) -> Unit) : RecyclerView.Adapter<MyTeamAdapter.MyTeamViewHolder>() {
    private var inflater: LayoutInflater? = null

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: MyTeamViewHolder?, position: Int) {
        holder?.bindata(context, names[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyTeamViewHolder {
        return MyTeamViewHolder(inflater!!.inflate(R.layout.item_team, parent, false),this::onclick)
    }

    fun onclick(index: Int){
        onclcikItem.invoke(index)
    }
    class MyTeamViewHolder(view: View, onClickItem: (index: Int) -> Unit) : RecyclerView.ViewHolder(view) {
        init {
            itemView.setOnClickListener {
                onClickItem.invoke(adapterPosition)
            }
        }

        fun bindata(context: Context, name: String) {
            itemView.tvName.text = name
            itemView.imgAvatar.setImageResource(FlagUtils.getFlagRectangle(context, name))
        }
    }
}