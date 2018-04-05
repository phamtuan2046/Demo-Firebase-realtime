package toolgamecorporation.worldcupschedule.presentations.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_my_team.*
import kotlinx.android.synthetic.main.app_bar_main.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.Constance
import toolgamecorporation.worldcupschedule.common.StoreData
import toolgamecorporation.worldcupschedule.presentations.MyApplication
import toolgamecorporation.worldcupschedule.presentations.adapter.MyTeamAdapter
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by FRAMGIA\pham.dinh.tuan on 29/03/2018.
 */
class TeamActivity : BaseActivity() {
    private var mMyTeamAdapter: MyTeamAdapter? = null
    var names = ArrayList<String>()
    var store: StoreData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_team)
        store = StoreData(this)
        initToolbar()
        initview()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        tvTitle.text = "Select your team"
        imageMyteam.visibility = View.GONE
    }

    fun initview() {
        var arrUnit = resources.getStringArray(R.array.country)
        var country: List<String> = ArrayList(Arrays.asList(*arrUnit))
        names.addAll(country)
        mMyTeamAdapter = MyTeamAdapter(this, names, this::onclickItem)
        rcvTeam.adapter = mMyTeamAdapter
    }

    fun onclickItem(index: Int) {
        application().store?.setStringValue(Constance.TEAM_KEY, names[index])
        var intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}