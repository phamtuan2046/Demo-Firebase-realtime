package toolgamecorporation.worldcupschedule.data.entity

/**
 * Created by FRAMGIA\pham.dinh.tuan on 27/03/2018.
 */
class TeamSortEntity {
    var name: String? = null

    var matches: Int = 0

    var matchW: Int = 0

    var matchD: Int = 0

    var matchL = matches - matchW - matchD
        get() = matches - matchW - matchD

    var recordGoals: Int = 0

    var allowGoals: Int = 0

    var goalDifference = recordGoals - allowGoals
        get() = recordGoals - allowGoals

    var point = matchW.times(3) + matchD
        get() = matchW.times(3) + matchD

    constructor(name: String) {
        this.name = name
    }

    constructor()
}