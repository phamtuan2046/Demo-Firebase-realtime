package toolgamecorporation.worldcupschedule.presentations.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import toolgamecorporation.worldcupschedule.R

/**
 * Created by Dell on 3/21/2018.
 */
class TopAdapter(var context:Context,frmn: FragmentManager, var fragments: List<Fragment>) : FragmentPagerAdapter(frmn) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount() = fragments.size
    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> context.resources.getString(R.string.tab_1_3)
            1 -> context.resources.getString(R.string.tab_2_3)
            else -> context.resources.getString(R.string.tab_3_3)
        }
    }
}