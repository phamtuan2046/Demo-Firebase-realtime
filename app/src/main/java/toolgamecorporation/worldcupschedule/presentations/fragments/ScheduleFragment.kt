package toolgamecorporation.worldcupschedule.presentations.fragments

import android.graphics.Color
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule_content.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.data.models.Schedule
import toolgamecorporation.worldcupschedule.presentations.views.ScheduleView
import toolgamecorporation.worldcupschedule.presentations.adapter.ScheduleAdapter
import toolgamecorporation.worldcupschedule.presentations.presenter.SchedulePresenter
import android.widget.AbsListView
import android.support.v7.widget.RecyclerView


/**
 * Created by FRAMGIA\pham.dinh.tuan on 21/03/2018.
 */
class ScheduleFragment : BaseFragment(), ScheduleView, SwipeRefreshLayout.OnRefreshListener {
    var mSchedule = ArrayList<Schedule>()
    var mScheduleAdapter: ScheduleAdapter? = null
    var mStage: String? = null
    private var mPresenter: SchedulePresenter? = null

    companion object {
        fun getInstance(stage: String): ScheduleFragment {
            var fragment = ScheduleFragment()
            fragment.mStage = stage
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = SchedulePresenter(mStage!!, this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_content, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initview()
        mPresenter?.getSchedule()
        scheduleRefresh.setColorSchemeColors(Color.RED, Color.YELLOW, Color.BLUE)
    }

    override fun onLoadedSchedule(schedule: ArrayList<Schedule>) {
        mSchedule.clear()
        mSchedule.addAll(schedule)
        mScheduleAdapter?.notifyDataSetChanged()
    }

    override fun showProgress(show: Boolean) {
        scheduleRefresh?.isRefreshing = show
    }

    override fun onRefresh() {
        mPresenter?.getSchedule()
    }

    fun initview() {
        scheduleRefresh.setOnRefreshListener(this)
        mScheduleAdapter = ScheduleAdapter(context, mSchedule)
        rcvSchedule.adapter = mScheduleAdapter
        rcvSchedule.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var layoutManager = rcvSchedule.layoutManager as LinearLayoutManager
                scheduleRefresh.isEnabled = if (layoutManager.findFirstCompletelyVisibleItemPosition() == 0) true else false

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }

}