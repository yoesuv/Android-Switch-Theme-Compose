package com.yoesuv.switchthemecompose

import android.app.Application
import com.yoesuv.switchthemecompose.utils.PreferencesHelper

class MyApp : Application() {
    companion object {
        var prefHelper: PreferencesHelper? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefHelper = PreferencesHelper(this)
    }
}
