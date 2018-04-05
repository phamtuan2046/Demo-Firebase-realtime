package toolgamecorporation.worldcupschedule.data.entity

/**
 * Created by FRAMGIA\pham.dinh.tuan on 02/04/2018.
 */
class StadiumEntity {
    var name:String? = null
    var city: String? = null
    var capacity: String? = null
    var matches = ArrayList<String>()

    constructor(name:String){
        this.name = name
    }
    constructor()
}