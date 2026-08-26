package com.yoesuv.switchthemecompose

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yoesuv.switchthemecompose.ui.theme.SwitchThemeComposeTheme
import com.yoesuv.switchthemecompose.ui.widget.ExitConfirmationDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwitchThemeScreen(
    isDarkTheme: Boolean,
    onThemeChanged: (Boolean) -> Unit,
) {
    var showExitDialog by remember { mutableStateOf(false) }
    val activity = LocalActivity.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier =
                Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 24.dp),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(stringResource(R.string.information))
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .toggleable(
                            value = isDarkTheme,
                            onValueChange = onThemeChanged,
                            role = Role.Switch,
                        ).padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(stringResource(R.string.app_dark_mode))
                Switch(
                    checked = isDarkTheme,
                    onCheckedChange = null,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { showExitDialog = true },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(stringResource(R.string.exit))
            }
            ExitConfirmationDialog(
                showDialog = showExitDialog,
                onDismiss = { showExitDialog = false },
                onExit = { activity?.finishAffinity() },
            )
        }
    }
}

@Preview
@Composable
fun SwitchThemeScreenPreview() {
    SwitchThemeComposeTheme {
        SwitchThemeScreen(
            isDarkTheme = false,
            onThemeChanged = {},
        )
    }
}
