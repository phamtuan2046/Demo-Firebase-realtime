package toolgamecorporation.worldcupschedule.data.entity

import java.util.*

/**
 * Created by Dell on 3/25/2018.
 */
class MatchEntity {
    var time: String? = null
    var stadium: String? = null
    var group: String? = null
    var teams = ArrayList<TeamEntity>()

    constructor(time: String?, stadium: String, group: String) {
        this.time = time
        this.stadium = stadium
        this.group = group
    }

    constructor()

}