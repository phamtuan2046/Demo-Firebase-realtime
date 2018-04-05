package toolgamecorporation.worldcupschedule.presentations.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import toolgamecorporation.worldcupschedule.di.component.AppComponent
import toolgamecorporation.worldcupschedule.presentations.MyApplication

/**
 * Created by Dell on 3/20/2018.
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        inject(application().appComponent())
    }
    protected fun application(): MyApplication {
        return this.application as MyApplication
    }

}