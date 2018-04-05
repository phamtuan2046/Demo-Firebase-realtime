package toolgamecorporation.worldcupschedule.presentations.presenter

import android.content.ContentValues
import android.util.Log
import com.google.firebase.database.*
import toolgamecorporation.worldcupschedule.data.entity.StadiumEntity
import toolgamecorporation.worldcupschedule.presentations.views.StadiumFragmentView

/**
 * Created by FRAMGIA\pham.dinh.tuan on 02/04/2018.
 */
class StadiumPresenter(tableId: String, var view: StadiumFragmentView) {
    private var mDatabase: DatabaseReference? = null
    private var stadiums = ArrayList<StadiumEntity>()
    private var mStadiums = ArrayList<StadiumEntity>()

    init {
        mDatabase = FirebaseDatabase.getInstance().reference.child(tableId)
    }

    fun getStadium() {
        view.showProgress(true)
        mStadiums.clear()
        mDatabase?.addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (snapshot in dataSnapshot.children) {
                            var data = snapshot.getValue(StadiumEntity::class.java) as StadiumEntity
                            mStadiums.add(data)
                        }
                        view.onLoadSuccess(mStadiums)
                        view.showProgress(false)
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        Log.d(ContentValues.TAG, "Value is: datasnapshot")
                        view.showProgress(false)
                    }
                })
    }
}