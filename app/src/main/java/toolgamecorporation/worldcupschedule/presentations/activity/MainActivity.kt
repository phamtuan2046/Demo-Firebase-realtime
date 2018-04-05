package toolgamecorporation.worldcupschedule.presentations.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.AppUtil
import toolgamecorporation.worldcupschedule.common.Constance
import toolgamecorporation.worldcupschedule.common.FlagUtils
import toolgamecorporation.worldcupschedule.presentations.dialogs.RateDialog
import toolgamecorporation.worldcupschedule.presentations.dialogs.TeamDialog
import toolgamecorporation.worldcupschedule.presentations.fragments.*
import toolgamecorporation.worldcupschedule.presentations.views.OnDissmiss
import com.google.android.gms.ads.InterstitialAd



class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, OnDissmiss {
    private var drawerMenu = 0
    var showdialog = false
    private val mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        navMain.setNavigationItemSelectedListener(this)
        replacefragment(TopFragment())
        tvTitle.text = resources.getString(R.string.nav_fixture)
        imageMyteam.setOnClickListener {
            showDialogMyTeam()
        }
    }
//
//    override fun inject(appComponent: AppComponent) {
//        inject(appComponent)
//    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if (showdialog) showdialog = false
            super.onBackPressed()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_fixture -> {
                if (drawerMenu != 0) {
                    drawerMenu = 0
                    replacefragment(TopFragment())
                    tvTitle.text = resources.getString(R.string.nav_fixture)
                }
            }
            R.id.nav_standings -> {
                if (drawerMenu != 1) {
                    drawerMenu = 1
                    replacefragment(StandingFragment())
                    tvTitle.text = resources.getString(R.string.nav_standings)
                }
            }
            R.id.nav_knockout -> {
                if (drawerMenu != 2) {
                    drawerMenu = 2
                    replacefragment(KnockoutFragment())
                    tvTitle.text = resources.getString(R.string.nav_knockout)
                }

            }
            R.id.nav_stadium -> {
                if (drawerMenu != 3) {
                    drawerMenu = 4
                    replacefragment(StadiumFragment())
                    tvTitle.text = resources.getString(R.string.nav_stadium)
                }

            }
            R.id.nav_rate_app -> {
//                AppUtil.gotoPlaystore(this)
                showDialogRateApp()
            }
            R.id.nav_about -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
            R.id.nav_more_app -> {
                AppUtil.gotoMyStore(this)
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onDismiss() {
        showdialog = false
    }

    private fun initToolbar() {
        var team = application().store?.getStringValue(Constance.TEAM_KEY)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayShowTitleEnabled(false)
        tvTitle.text = resources.getString(R.string.nav_fixture)
        setMyTeam(team!!)
    }

    fun setMyTeam(name: String) {
        imageMyteam.setImageResource(FlagUtils.getFlag(this, name))
    }

    private fun replacefragment(fragment: Fragment) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.content_main, fragment)
//        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun showDialogRateApp() {
        var dialog = RateDialog()
        dialog.show(fragmentManager, null)
    }

    fun showDialogMyTeam() {
        var dialog = TeamDialog.newInstance(this::setMyTeam)
        dialog.listener = this
        dialog.show(fragmentManager, null)
    }
}
