package toolgamecorporation.worldcupschedule.presentations.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter

/**
 * Created by FRAMGIA\pham.dinh.tuan on 27/03/2018.
 */
class StandingPageAdapter(frg: FragmentManager, var fragments: List<Fragment>) : FragmentPagerAdapter(frg) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "A"
            1 -> "B"
            2 -> "C"
            3 -> "D"
            4 -> "E"
            5 -> "F"
            6 -> "G"
            else -> "H"
        }
    }
}