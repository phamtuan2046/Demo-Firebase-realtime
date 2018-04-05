package toolgamecorporation.worldcupschedule.presentations.fragments

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import kotlinx.android.synthetic.main.fragment_top.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.Constance
import toolgamecorporation.worldcupschedule.presentations.adapter.KnockoutAdapter

/**
 * Created by Dell on 3/28/2018.
 */
class KnockoutFragment:BaseFragment() {
    var topAdapter: KnockoutAdapter? = null
    var fragments = listOf<Fragment>(
            ScheduleFragment.getInstance(Constance.FIRST_STAGE_1_16),
            ScheduleFragment.getInstance(Constance.QUARTER_FINALS),
            ScheduleFragment.getInstance(Constance.SEMI_FINALS),
            ScheduleFragment.getInstance(Constance.FINAL))

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_top, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(R.drawable.background).asBitmap().into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {
                val drawable = BitmapDrawable(context.resources, resource)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mainKnock.background = drawable
                }
            }
        })
        initView()
    }

    private fun initView() {
        topAdapter = KnockoutAdapter(context, childFragmentManager, fragments)
        mainViewpager.adapter = topAdapter
        mainViewpager.offscreenPageLimit = 3
        tabTop.setupWithViewPager(mainViewpager)
        mainViewpager.currentItem = 0
    }

}