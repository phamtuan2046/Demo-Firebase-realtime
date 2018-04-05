package toolgamecorporation.worldcupschedule.presentations.fragments

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule_content.*
import kotlinx.android.synthetic.main.fragment_standing_content.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.data.entity.TeamSortEntity
import toolgamecorporation.worldcupschedule.presentations.adapter.StandingAdapter
import toolgamecorporation.worldcupschedule.presentations.adapter.StandingPageAdapter
import toolgamecorporation.worldcupschedule.presentations.presenter.StandingPresenter
import toolgamecorporation.worldcupschedule.presentations.views.StandingFragmentView

/**
 * Created by FRAMGIA\pham.dinh.tuan on 27/03/2018.
 */
class StandingContenFragment : BaseFragment(), StandingFragmentView, SwipeRefreshLayout.OnRefreshListener {
    val TAG = StandingContenFragment::class.java.name
    var mName: String? = null
    var mPresenter: StandingPresenter? = null
    var mStandingAdapter: StandingAdapter? = null
    var datas = ArrayList<Any>()

    companion object {
        fun newInstance(name: String): StandingContenFragment {
            var fragment = StandingContenFragment()
            fragment.mName = name
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = StandingPresenter(mName!!, this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_standing_content, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        swipeStanding.setColorSchemeColors(Color.RED, Color.YELLOW, Color.BLUE)
        swipeStanding.setOnRefreshListener(this)
        mPresenter?.getdata()
    }

    override fun showProgress(show: Boolean) {
        swipeStanding?.isRefreshing = show
    }

    override fun onRefresh() {
        mPresenter?.getdata()
    }

    override fun loadStanding(teams: ArrayList<TeamSortEntity>) {
        datas.clear()
        datas.add(mName!!)
        datas.addAll(teams!!)
        mStandingAdapter?.notifyDataSetChanged()
    }

    fun initView() {
        mStandingAdapter = StandingAdapter(context, datas)
        rcvStanding.adapter = mStandingAdapter
    }
}