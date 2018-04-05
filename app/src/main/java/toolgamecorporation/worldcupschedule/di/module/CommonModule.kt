package toolgamecorporation.worldcupschedule.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Dell on 3/20/2018.
 */
@Module
class CommonModule(application: Application) {
    private val application: Application

    init {
        this.application = application
    }

    @Provides
    fun provideApplicationContext(): Context {
        return application.applicationContext
    }
}