package com.yoesuv.switchthemecompose.utils

import android.content.Context
import androidx.core.content.edit
import com.yoesuv.switchthemecompose.BuildConfig

class PreferencesHelper(
    context: Context,
) {
    companion object {
        const val PREF_KEY_DARK_THEME = "dark_theme"
    }

    private val name = "${BuildConfig.APPLICATION_ID}_pref"
    private val prefHelper = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    fun setBoolean(
        key: String,
        value: Boolean,
    ) {
        prefHelper.edit { putBoolean(key, value) }
    }

    fun getBoolean(key: String): Boolean = prefHelper.getBoolean(key, false)
}
