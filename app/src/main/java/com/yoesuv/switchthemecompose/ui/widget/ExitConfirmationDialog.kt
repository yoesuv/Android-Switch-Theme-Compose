package com.yoesuv.switchthemecompose.ui.widget

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.yoesuv.switchthemecompose.R

@Composable
fun ExitConfirmationDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onExit: () -> Unit,
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(stringResource(R.string.exit_dialog_title)) },
            text = { Text(stringResource(R.string.exit_dialog_message)) },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDismiss()
                        onExit()
                    },
                ) {
                    Text(stringResource(R.string.yes))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismiss,
                ) {
                    Text(stringResource(R.string.no))
                }
            },
        )
    }
}
