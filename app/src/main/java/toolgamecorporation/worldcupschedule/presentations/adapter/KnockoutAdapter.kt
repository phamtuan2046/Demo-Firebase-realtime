package toolgamecorporation.worldcupschedule.presentations.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import toolgamecorporation.worldcupschedule.R

/**
 * Created by Dell on 3/28/2018.
 */
class KnockoutAdapter(var context: Context, frg: FragmentManager, var fragments: List<Fragment>) : FragmentPagerAdapter(frg) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> {
                context.resources.getString(R.string.knockout_tab_1)
            }
            1 -> {
                context.resources.getString(R.string.knockout_tab_2)
            }
            2 -> {
                context.resources.getString(R.string.knockout_tab_3)
            }
            else -> {
                context.resources.getString(R.string.knockout_tab_4)
            }
        }
    }
}