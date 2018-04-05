package toolgamecorporation.worldcupschedule.presentations.widget

import android.content.Context
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import toolgamecorporation.worldcupschedule.R

/**
 * Created by Dell on 3/21/2018.
 */
class TabItemView : RelativeLayout {
    var tvTitle: TextView? = null

    companion object {
        fun create(context: Context, idx: Int): TabItemView {
            val ret = TabItemView(context, idx)
            return ret
        }
    }

    constructor(context: Context, idx: Int) : super(context) {
        var view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null)
        tvTitle = view.findViewById(R.id.tvTitle)
    }
}