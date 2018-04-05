package toolgamecorporation.worldcupschedule.presentations.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_splash.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.Constance

/**
 * Created by FRAMGIA\pham.dinh.tuan on 29/03/2018.
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Glide.with(this).load(R.drawable.splash).fitCenter().into(imgSplash)
        var team = application().store?.getStringValue(Constance.TEAM_KEY)
        Handler().postDelayed(Runnable {
            if (team == null) {
                var intent = Intent(this@SplashActivity, TeamActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                var intent = Intent(this@SplashActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }, 1000)
    }
}