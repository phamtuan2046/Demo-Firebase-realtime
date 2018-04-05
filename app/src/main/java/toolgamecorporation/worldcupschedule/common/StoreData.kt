package toolgamecorporation.worldcupschedule.common

import android.content.Context
import android.content.SharedPreferences


/**
 * Created by FRAMGIA\pham.dinh.tuan on 29/03/2018.
 */
class StoreData {

    var prefs: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var mContext: Context? = null
    var store: StoreData? = null

    constructor(context: Context) {
        this.mContext = context
        prefs = mContext?.getSharedPreferences("world.Data",
                Context.MODE_PRIVATE)
    }

    companion object {
        fun getIntance(context: Context): StoreData {
            return StoreData(context)
        }
    }

    fun delete() {
        prefs!!.edit().clear().apply()
    }

    fun getStringValue(key: String): String? {
        return prefs!!.getString(key, null)
    }

    fun setStringValue(key: String, value: String) {
        if (editor == null) {
            editor = prefs!!.edit()
        }
        editor!!.putString(key, value)
        editor!!.commit()
    }

    fun getIntValue(key: String): Int {
        return prefs!!.getInt(key, 0)
    }

    fun setIntValue(key: String, value: Int) {
        if (editor == null) {
            editor = prefs!!.edit()
        }
        editor!!.putInt(key, value)
        editor!!.commit()
    }

    fun removeKey(key: String) {
        if (editor == null) {
            editor = prefs!!.edit()
        }
        editor!!.remove(key)
        editor!!.commit()
    }

    fun setBooleanValue(key: String, value: Boolean) {
        if (editor == null) {
            editor = prefs!!.edit()
        }
        editor!!.putBoolean(key, value)
        editor!!.commit()
    }


    fun getBooleanValue(key: String): Boolean {
        return prefs!!.getBoolean(key, false)
    }

    fun putBoolean(permission: String, b: Boolean) {
        if (editor == null) {
            editor = prefs!!.edit()
        }
        editor!!.putBoolean(permission, b)
        editor!!.commit()
    }

    fun getBoolean(permission: String, b: Boolean): Boolean {
        return prefs!!.getBoolean(permission, false)
    }
}