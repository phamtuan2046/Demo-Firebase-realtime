package toolgamecorporation.worldcupschedule.presentations.dialogs

import android.app.DialogFragment
import android.graphics.Rect
import android.os.Bundle
import android.support.v4.app.ShareCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout
import android.widget.RatingBar
import kotlinx.android.synthetic.main.dialog_rate_app.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.AppUtil

class RateDialog : DialogFragment(), RatingBar.OnRatingBarChangeListener {
    val TAG = RateDialog::class.java.name
    var star = 0f
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.dialog_rate_app, container, false)
        val displayRectangle = Rect()
        dialog.window.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window.decorView.getWindowVisibleDisplayFrame(displayRectangle)
        isCancelable = false
        view?.minimumWidth = (displayRectangle.width() * 0.9f).toInt()
        view?.minimumHeight = LinearLayout.LayoutParams.WRAP_CONTENT
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rateBar.onRatingBarChangeListener = this
        btnCancel.setOnClickListener { dismiss() }
        btnRate.setOnClickListener {
            if (star > 2f) {
                dismiss()
                AppUtil.gotoPlaystore(activity)
            } else {
                AppUtil.sendFeedback(activity)
                dismiss()
            }
        }
    }

    override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
        star = p1
    }
}