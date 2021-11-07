package com.example.sharedpreferencesapp.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceUtil {

    private fun getPreference(context: Context?): SharedPreferences? =
        context?.getSharedPreferences(Constants.prefFileName, Context.MODE_PRIVATE)

    private fun getPreferenceData(context: Context?): SharedPreferences? =
        context?.getSharedPreferences(Constants.prefFileData, Context.MODE_PRIVATE)

    //save and load username
    fun saveUserName(context: Context?,   userName : String){
        val editor = getPreference(context)?.edit()
        editor?.putString(Constants.userName, userName)
        editor?.apply()
    }
    fun getUserName(context: Context?) =
        getPreference(context)?.getString(Constants.userName, "") ?: ""

    //save and load Full Name
    fun saveFullName(context: Context?,   fullName : String){
        val editor = getPreference(context)?.edit()
        editor?.putString(Constants.fullName, fullName)
        editor?.apply()
    }
    fun getFullName(context: Context?) =
        getPreference(context)?.getString(Constants.fullName, "") ?: ""

    //save and load password
    fun savePassword(context: Context?,   pass : String){
        val editor = getPreference(context)?.edit()
        editor?.putString(Constants.password, pass)
        editor?.apply()
    }
    fun getPassword(context: Context?) =
        getPreference(context)?.getString(Constants.password, "") ?: ""


    fun getLoginState(context: Context?) =
        getPreference(context)?.getBoolean(Constants.isLoggedIn, false)?: false

    fun clearAll(context: Context?) {
        getPreference(context)?.edit()?.clear()?.apply()
    }

    fun removeLoginState(context: Context?) {
        getPreference(context)?.edit()?.remove(Constants.isLoggedIn)?.apply()
    }

}