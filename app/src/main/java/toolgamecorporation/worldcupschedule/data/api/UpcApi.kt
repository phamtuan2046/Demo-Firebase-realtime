package toolgamecorporation.worldcupschedule.data.api

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import toolgamecorporation.worldcupschedule.data.models.UpcResponse

/**
 * Created by Dell on 3/20/2018.
 */
interface UpcApi {
    @GET("prod/trial/lookup")
    fun getInfoByBarcode(@Query("upc") barcode: String): Observable<Response<UpcResponse>>
}