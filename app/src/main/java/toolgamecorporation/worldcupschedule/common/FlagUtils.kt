package toolgamecorporation.worldcupschedule.common

import android.content.Context
import toolgamecorporation.worldcupschedule.R
import java.util.*
import android.content.res.TypedArray


/**
 * Created by Dell on 3/22/2018.
 */
object FlagUtils {
    fun getFlag(context: Context, flag: String): Int {
        var arrUnit = context.resources.getStringArray(R.array.country)
        var country: List<String> = ArrayList(Arrays.asList(*arrUnit))
        var index = country.indexOf(flag)
        if (index != -1) {
            val imgs = context.resources.obtainTypedArray(R.array.flag)
            return imgs.getResourceId(index, -1)
        } else {
            return index
        }
    }
    fun getFlagRectangle(context: Context, flag: String): Int {
        var arrUnit = context.resources.getStringArray(R.array.country)
        var country: List<String> = ArrayList(Arrays.asList(*arrUnit))
        var index = country.indexOf(flag)
        if (index != -1) {
            val imgs = context.resources.obtainTypedArray(R.array.flag_sq)
            return imgs.getResourceId(index, -1)
        } else {
            return index
        }
    }

    fun getStadium(context: Context,stadium:String):Int{
        var arrUnit = context.resources.getStringArray(R.array.stadiums)
        var stadiums: List<String> = ArrayList(Arrays.asList(*arrUnit))
        var index = stadiums.indexOf(stadium)
        if (index != -1) {
            val imgs = context.resources.obtainTypedArray(R.array.stadium_image)
            return imgs.getResourceId(index, -1)
        } else {
            return index
        }
    }
}