package com.ncautomation.flashlight.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ncautomation.commons.compose.extensions.MyDevices
import com.ncautomation.commons.compose.theme.AppThemeSurface
import com.ncautomation.commons.compose.theme.SimpleTheme
import com.ncautomation.commons.extensions.getContrastColor
import com.ncautomation.flashlight.R
import com.ncautomation.flashlight.views.AnimatedSleepTimer

@Composable
internal fun BrightDisplayScreen(
    backgroundColor: Int,
    contrastColor: Int,
    onChangeColorPress: () -> Unit,
    sleepTimer: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(backgroundColor))
            .safeDrawingPadding()
    ) {
        TextButton(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
                .border(
                    width = 1.dp,
                    color = Color(contrastColor),
                    shape = SimpleTheme.shapes.extraLarge
                ),
            onClick = onChangeColorPress
        ) {
            Text(
                text = stringResource(id = com.ncautomation.commons.R.string.change_color),
                color = Color(contrastColor)
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            sleepTimer()
        }
    }
}

@Composable
@MyDevices
private fun BrightDisplayScreenPreview() {
    AppThemeSurface {
        BrightDisplayScreen(
            backgroundColor = SimpleTheme.colorScheme.background.toArgb(),
            contrastColor = SimpleTheme.colorScheme.background.toArgb().getContrastColor(),
            sleepTimer = {
                AnimatedSleepTimer(timerText = "00:00", timerVisible = true, onTimerClosePress = {})
            },
            onChangeColorPress = {},
        )
    }
}
