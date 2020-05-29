package com.example.tictactoe

import android.content.Context
import android.content.SharedPreferences


import androidx.fragment.app.FragmentActivity

class SessionStorage(activity: FragmentActivity) {
    /*
    * val sessionStorage = activity?.let { SessionStorage(it) }
    *
    * */

    private val sharedPref: SharedPreferences = activity.getPreferences(Context.MODE_PRIVATE)
    private val edit = sharedPref.edit()

    // sessionStorage!!.setStorage(getString(R.string.KEY), VALUE)
    fun setStorage(key: String, value: String) {
        edit.putString(key, value);
        edit.apply();
    }

    // sessionStorage!!.getStorage(getString(R.string.game_mode))
    fun getStorage(key: String, default: String = "not set"): String? = sharedPref.getString(key, default)

}