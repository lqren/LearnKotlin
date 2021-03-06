package com.example.base.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.bae.R
import com.example.base.BaseApplication

object CacheUtils {
    private val context: Context = BaseApplication.currentApplication;

    private val SP: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);

    fun save(key: String, value: String?) = SP.edit().putString(key, value).apply();

    fun get(key: String) = SP.getString(key, null);

}