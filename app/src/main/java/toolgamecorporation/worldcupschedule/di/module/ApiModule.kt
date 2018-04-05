package toolgamecorporation.worldcupschedule.di.module

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import toolgamecorporation.worldcupschedule.data.api.UpcApi
import javax.inject.Singleton

/**
 * Created by Dell on 3/20/2018.
 */
@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideLoginApi(retrofit: Retrofit): UpcApi {
        return retrofit.create<UpcApi>(UpcApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(context: Context): Retrofit {
        val httpClient = OkHttpClient.Builder()
//        httpClient.addInterceptor(HttpHeaderInterceptor())
//        httpClient.addInterceptor(ApiExceptionInterceptor())
////        httpClient.authenticator(TokenRefreshAuthenticator()) // モバイルはトークンの期限制限がない
//        if (BuildConfig.DEBUG) {
//            val logging = HttpLoggingInterceptor()
//            logging.level = HttpLoggingInterceptor.Level.BASIC
//            httpClient.addInterceptor(logging)
//        }
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ").serializeNulls().create()

        return Retrofit.Builder()
                .baseUrl("https://api.upcitemdb.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build()
    }
}