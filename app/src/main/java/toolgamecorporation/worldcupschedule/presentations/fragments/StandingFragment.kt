package toolgamecorporation.worldcupschedule.presentations.fragments

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import kotlinx.android.synthetic.main.fragment_standing.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.Constance
import toolgamecorporation.worldcupschedule.presentations.adapter.StandingPageAdapter

/**
 * Created by FRAMGIA\pham.dinh.tuan on 22/03/2018.
 */
class StandingFragment : BaseFragment() {
    var mStandingAdapter: StandingPageAdapter? = null
    var fragments = listOf(
            StandingContenFragment.newInstance(Constance.A),
            StandingContenFragment.newInstance(Constance.B),
            StandingContenFragment.newInstance(Constance.C),
            StandingContenFragment.newInstance(Constance.D),
            StandingContenFragment.newInstance(Constance.E),
            StandingContenFragment.newInstance(Constance.F),
            StandingContenFragment.newInstance(Constance.G),
            StandingContenFragment.newInstance(Constance.H))

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_standing, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(R.drawable.background).asBitmap().into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {
                val drawable = BitmapDrawable(context.resources, resource)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mainStanding.background = drawable
                }
            }
        })
        initView()
    }

    private fun initView() {
        mStandingAdapter = StandingPageAdapter(childFragmentManager, fragments)
        standinViewpagerg.adapter = mStandingAdapter
        standinViewpagerg.offscreenPageLimit = 3
        tabStanding.setupWithViewPager(standinViewpagerg)
        standinViewpagerg.currentItem = 0
    }

}