package toolgamecorporation.worldcupschedule.presentations.views

import toolgamecorporation.worldcupschedule.data.entity.StadiumEntity

/**
 * Created by FRAMGIA\pham.dinh.tuan on 02/04/2018.
 */
interface StadiumFragmentView {
    fun showProgress(show:Boolean)

    fun onLoadSuccess(stadiums:ArrayList<StadiumEntity>)
}