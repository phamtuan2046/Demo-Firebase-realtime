package toolgamecorporation.worldcupschedule.presentations.presenter

import android.content.ContentValues
import android.util.Log
import com.google.firebase.database.*
import toolgamecorporation.worldcupschedule.data.entity.TeamSortEntity
import toolgamecorporation.worldcupschedule.presentations.views.StandingFragmentView

/**
 * Created by FRAMGIA\pham.dinh.tuan on 27/03/2018.
 */
class StandingPresenter(childId: String, var view: StandingFragmentView) {
    private var mDatabase: DatabaseReference? = null
    private var teams = ArrayList<TeamSortEntity>()

    init {
        mDatabase = FirebaseDatabase.getInstance().reference.child(childId)
    }

    fun getdata() {
        view.showProgress(true)
        teams.clear()
        mDatabase?.addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (snapshot in dataSnapshot.children) {
                            var data = snapshot.getValue(TeamSortEntity::class.java) as TeamSortEntity
                            teams.add(data)
                        }
                        teams.sortWith(compareByDescending <TeamSortEntity> { it.point }.thenByDescending { it.goalDifference })
                        view.loadStanding(teams)
                        view.showProgress(false)
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        Log.d(ContentValues.TAG, "Value is: datasnapshot")
                        view.showProgress(false)
                    }
                })
    }
}