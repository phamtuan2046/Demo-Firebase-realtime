package toolgamecorporation.worldcupschedule.data.repository

import io.reactivex.Observable
import toolgamecorporation.worldcupschedule.data.models.UpcResponse

/**
 * Created by Dell on 3/20/2018.
 */
interface UpcRepos {
    fun getDataUpc(barcode: String): Observable<UpcResponse>
}