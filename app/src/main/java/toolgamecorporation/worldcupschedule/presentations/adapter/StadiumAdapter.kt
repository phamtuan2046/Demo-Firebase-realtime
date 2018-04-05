package toolgamecorporation.worldcupschedule.presentations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.FlagUtils
import toolgamecorporation.worldcupschedule.data.entity.StadiumEntity

/**
 * Created by FRAMGIA\pham.dinh.tuan on 02/04/2018.
 */
class StadiumAdapter(var context: Context, var stadiums: ArrayList<StadiumEntity>) : BaseAdapter() {
    var inflater: LayoutInflater? = null

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var view = inflater!!.inflate(R.layout.item_stadidum, p2, false)
        var tvCity = view.findViewById<TextView>(R.id.tvCity)
        var tvCapacity = view.findViewById<TextView>(R.id.tvCapacity)
        var img = view.findViewById<ImageView>(R.id.imgStadium)
        tvCity.text = stadiums[position].city
        tvCapacity.text = stadiums[position].capacity
        Glide.with(context).load(FlagUtils.getStadium(context,stadiums[position].name!!)).asBitmap().into(img)
        return view
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return stadiums.size
    }
}