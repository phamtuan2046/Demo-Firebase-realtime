package toolgamecorporation.worldcupschedule.presentations.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ShareCompat
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.ViewTarget
import kotlinx.android.synthetic.main.activity_about.*
import toolgamecorporation.worldcupschedule.BuildConfig
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.AppUtil
import android.os.Build
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.Bitmap
import com.bumptech.glide.request.animation.GlideAnimation


/**
 * Created by Dell on 3/29/2018.
 */
class AboutActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        action_rate.setOnClickListener(this)
        action_support.setOnClickListener(this)
        action_share.setOnClickListener(this)
        action_feedback.setOnClickListener(this)
        action_google_plus.setOnClickListener(this)
        action_facebook.setOnClickListener(this)
        setSupportActionBar(toolbar)
        Glide.with(this).load(R.drawable.background).asBitmap().into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {
                val drawable = BitmapDrawable(this@AboutActivity.resources, resource)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mainAbout.background = drawable
                }
            }
        })
        toolbar.title = resources.getString(R.string.about_title)
        btnBack.setOnClickListener { finish() }
    }

    override fun onClick(view: View?) {
        when (view!!.getId()) {
            R.id.action_google_plus -> startActivity(Intent("android.intent.action.VIEW",
                    Uri.parse("https://plus.google.com/u/0/101563919795060381540")))
            R.id.action_feedback -> openFeedback()
            R.id.action_rate -> AppUtil.gotoPlaystore(this)
            R.id.action_support -> {
                AppUtil.gotoMyStore(this)
            }
            R.id.action_share -> {
                var uri = Uri.parse("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                val shareText = "I found this file mananger very useful. Give it a try. " + uri.toString()
                ShareCompat.IntentBuilder
                        .from(this)
                        .setText(shareText)
                        .setType("text/plain")
                        .setChooserTitle("Share AnExplorer")
                        .startChooser()
            }
            R.id.action_facebook -> openFaceBook()
        }
    }

    fun openFeedback() {
        ShareCompat.IntentBuilder
                .from(this)
                .setEmailTo(arrayOf("phamtuan2046@gmail.com"))
                .setSubject("World Schedule")
                .setType("text/email")
                .setChooserTitle("Send Feedback")
                .startChooser()
    }

    fun openFaceBook() {
        var link = "https://www.facebook.com/Android-Learning-Share-1948571468789880/"
        try {
            packageManager.getPackageInfo("com.facebook.katana", 0)
            link = "fb://page/1948571468789880"
        } catch (ignored: Exception) {
        }
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    }
}