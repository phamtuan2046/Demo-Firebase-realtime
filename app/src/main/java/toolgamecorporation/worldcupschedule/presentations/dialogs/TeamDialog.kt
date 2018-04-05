package toolgamecorporation.worldcupschedule.presentations.dialogs

import android.app.DialogFragment
import android.graphics.Bitmap
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import kotlinx.android.synthetic.main.fragment_my_team.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.Constance
import toolgamecorporation.worldcupschedule.common.StoreData
import toolgamecorporation.worldcupschedule.presentations.adapter.MyTeamAdapter
import toolgamecorporation.worldcupschedule.presentations.views.OnDissmiss
import java.util.*

class TeamDialog : DialogFragment() {
    var mMyTeamAdapter: MyTeamAdapter? = null
    var names = ArrayList<String>()
    var store: StoreData? = null
    lateinit var mOnSelete: (name: String) -> Unit
    var listener: OnDissmiss? = null

    companion object {
        fun newInstance(onSelete: (name: String) -> Unit): TeamDialog {
            var dialog = TeamDialog()
            dialog.mOnSelete = onSelete
            return dialog
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        store = StoreData(activity)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.fragment_my_team, container, false)
        val displayRectangle = Rect()
        dialog.window.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window.decorView.getWindowVisibleDisplayFrame(displayRectangle)
        view?.minimumWidth = (displayRectangle.width() * 0.9f).toInt()
        view?.minimumHeight = LinearLayout.LayoutParams.WRAP_CONTENT
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(R.drawable.background).asBitmap().into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {
                val drawable = BitmapDrawable(activity.resources, resource)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mainView.background = drawable
                }
            }
        })
        initview()
    }

    fun initview() {
        var arrUnit = resources.getStringArray(R.array.country)
        var country: List<String> = ArrayList(Arrays.asList(*arrUnit))
        names.addAll(country)
        mMyTeamAdapter = MyTeamAdapter(activity, names, this::onclickItem)
        rcvTeam.adapter = mMyTeamAdapter
    }

    fun onclickItem(index: Int) {
        store?.setStringValue(Constance.TEAM_KEY, names[index])
        mOnSelete.invoke(names[index])
        dismiss()
        listener?.onDismiss()
    }
}