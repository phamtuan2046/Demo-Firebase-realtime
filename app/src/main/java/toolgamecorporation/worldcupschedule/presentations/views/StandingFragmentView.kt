package toolgamecorporation.worldcupschedule.presentations.views

import toolgamecorporation.worldcupschedule.data.entity.TeamSortEntity

/**
 * Created by FRAMGIA\pham.dinh.tuan on 27/03/2018.
 */
interface StandingFragmentView {
    fun showProgress(show: Boolean)

    fun loadStanding(teams: ArrayList<TeamSortEntity>)
}