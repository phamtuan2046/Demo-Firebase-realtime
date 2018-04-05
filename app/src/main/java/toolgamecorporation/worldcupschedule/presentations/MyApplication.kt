package toolgamecorporation.worldcupschedule.presentations

import android.app.Application
import toolgamecorporation.worldcupschedule.common.StoreData
import toolgamecorporation.worldcupschedule.di.component.AppComponent
import toolgamecorporation.worldcupschedule.di.component.DaggerAppComponent
import toolgamecorporation.worldcupschedule.di.module.CommonModule

/**
 * Created by Dell on 3/20/2018.
 */
class MyApplication : Application() {
    protected lateinit var appComponent: AppComponent
    var store: StoreData? = null
    override fun onCreate() {
        super.onCreate()
        initDagger()
        store = StoreData(this)
    }

    open protected fun initDagger() {
        appComponent = DaggerAppComponent.builder()
                .commonModule(CommonModule(this))
                .build()
    }

    open fun appComponent(): AppComponent {
        return appComponent
    }
}