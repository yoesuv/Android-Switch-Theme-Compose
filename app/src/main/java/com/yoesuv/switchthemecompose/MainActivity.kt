package com.yoesuv.switchthemecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.yoesuv.switchthemecompose.ui.theme.SwitchThemeComposeTheme
import com.yoesuv.switchthemecompose.utils.PreferencesHelper
import com.yoesuv.switchthemecompose.utils.PreferencesHelper.Companion.PREF_KEY_DARK_THEME

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val prefHelper = remember { PreferencesHelper(context) }
            var isDarkTheme by remember { mutableStateOf(prefHelper.getBoolean(PREF_KEY_DARK_THEME)) }

            SwitchThemeComposeTheme(
                darkTheme = isDarkTheme,
                dynamicColor = false,
            ) {
                SwitchThemeScreen(
                    onThemeChanged = { newTheme ->
                        isDarkTheme = newTheme
                        prefHelper.setBoolean(PREF_KEY_DARK_THEME, newTheme)
                    }
                )
            }
        }
    }
}