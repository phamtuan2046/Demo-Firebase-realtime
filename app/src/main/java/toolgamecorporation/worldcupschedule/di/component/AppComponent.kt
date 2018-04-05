package toolgamecorporation.worldcupschedule.di.component

import dagger.Component
import toolgamecorporation.worldcupschedule.di.module.ApiModule
import toolgamecorporation.worldcupschedule.di.module.CommonModule
import toolgamecorporation.worldcupschedule.di.module.RepositoryModule
import toolgamecorporation.worldcupschedule.presentations.activity.BaseActivity
import javax.inject.Singleton

/**
 * Created by Dell on 3/20/2018.
 */
@Singleton
@Component(modules = arrayOf(CommonModule::class, RepositoryModule::class, ApiModule::class))
interface AppComponent {
    fun inject(activity: BaseActivity)
}