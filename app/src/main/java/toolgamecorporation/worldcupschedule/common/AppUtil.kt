package toolgamecorporation.worldcupschedule.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.app.ShareCompat

/**
 * Created by Dell on 3/29/2018.
 */
object AppUtil {
    fun gotoPlaystore(context: Context) {
        val appPackageName = context.packageName // getPackageName() from Context or Activity object
        try {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)))
        } catch (anfe: android.content.ActivityNotFoundException) {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)))
        }
    }
    fun gotoMyStore(context: Context){
       
    }
    fun sendFeedback(activity: Activity){
        ShareCompat.IntentBuilder
                .from(activity)
                .setEmailTo(arrayOf("youremail"))
                .setSubject("World Schedule")
                .setType("text/email")
                .setChooserTitle("Send Feedback")
                .startChooser()
    }
}
