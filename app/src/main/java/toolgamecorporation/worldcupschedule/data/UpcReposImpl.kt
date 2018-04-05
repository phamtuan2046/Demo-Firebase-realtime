package toolgamecorporation.worldcupschedule.data

import io.reactivex.Observable
import toolgamecorporation.worldcupschedule.data.api.UpcApi
import toolgamecorporation.worldcupschedule.data.models.UpcResponse
import toolgamecorporation.worldcupschedule.data.repository.UpcRepos
import javax.inject.Inject

/**
 * Created by Dell on 3/20/2018.
 */
class UpcReposImpl: UpcRepos {
    @Inject
    lateinit var api: UpcApi

    @Inject
    constructor() {
    }
    override fun getDataUpc(barcode: String): Observable<UpcResponse> {
        return api.getInfoByBarcode(barcode).map { response ->
            response.body()
        }
    }
}