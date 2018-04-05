package toolgamecorporation.worldcupschedule.presentations.fragments

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import toolgamecorporation.worldcupschedule.R
import kotlinx.android.synthetic.main.fragment_stadiums.*
import toolgamecorporation.worldcupschedule.common.Constance
import toolgamecorporation.worldcupschedule.data.entity.StadiumEntity
import toolgamecorporation.worldcupschedule.presentations.adapter.StadiumAdapter
import toolgamecorporation.worldcupschedule.presentations.presenter.StadiumPresenter
import toolgamecorporation.worldcupschedule.presentations.views.StadiumFragmentView
import android.widget.AbsListView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import kotlinx.android.synthetic.main.fragment_top.*
import uk.co.senab.photoview.PhotoViewAttacher


/**
 * Created by Dell on 3/29/2018.
 */
class StadiumFragment : BaseFragment(), StadiumFragmentView, SwipeRefreshLayout.OnRefreshListener {
    var mPresenter: StadiumPresenter? = null
    var stadiums = ArrayList<StadiumEntity>()
    var mStadiumAdapterAdapter: StadiumAdapter? = null
    var mStadiums = ArrayList<StadiumEntity>()

    var mAttacher: PhotoViewAttacher? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = StadiumPresenter(Constance.STADIUM, this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_stadiums, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(R.drawable.background).asBitmap().into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {
                val drawable = BitmapDrawable(context.resources, resource)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mainStaidum.background = drawable
                }
            }
        })
        Glide.with(context)
                .load(R.drawable.stadium_map)
                .fitCenter()
                .into(expandedImageView)
        initview()
        mPresenter?.getStadium()
        mAttacher = PhotoViewAttacher(expandedImageView)
    }

    override fun showProgress(show: Boolean) {
        swStaidum?.isRefreshing = show
    }

    override fun onLoadSuccess(stadiums: ArrayList<StadiumEntity>) {
        mStadiums.clear()
        mStadiums.addAll(stadiums)
        mStadiumAdapterAdapter?.notifyDataSetChanged()
    }

    override fun onRefresh() {
        mPresenter?.getStadium()
    }

    fun initview() {
        swStaidum.setOnRefreshListener(this)
        mStadiumAdapterAdapter = StadiumAdapter(context, mStadiums)
        rcvStadium.adapter = mStadiumAdapterAdapter
        rcvStadium.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScroll(view: AbsListView?, p1: Int, p2: Int, p3: Int) {
                swStaidum.isEnabled = if (view?.firstVisiblePosition == 0) true else false
            }

            override fun onScrollStateChanged(p0: AbsListView?, p1: Int) {

            }
        })
    }
}