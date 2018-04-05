package toolgamecorporation.worldcupschedule.data.models

import toolgamecorporation.worldcupschedule.data.entity.MatchEntity
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by FRAMGIA\pham.dinh.tuan on 21/03/2018.
 */
class Schedule {
    var date: Date? = null
    var matchs = ArrayList<MatchEntity>()
}