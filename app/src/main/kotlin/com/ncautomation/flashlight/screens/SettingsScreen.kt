package com.ncautomation.flashlight.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ncautomation.commons.compose.extensions.MyDevices
import com.ncautomation.commons.compose.lists.SimpleColumnScaffold
import com.ncautomation.commons.compose.settings.*
import com.ncautomation.commons.compose.theme.AppThemeSurface
import com.ncautomation.flashlight.R

@Composable
internal fun SettingsScreen(
    colorCustomizationSection: @Composable () -> Unit,
    generalSection: @Composable () -> Unit,
    goBack: () -> Unit,
) {
    SimpleColumnScaffold(title = stringResource(id = com.ncautomation.commons.R.string.settings), goBack = goBack) {
        SettingsGroup(title = {
            SettingsTitleTextComponent(text = stringResource(id = com.ncautomation.commons.R.string.color_customization))
        }) {
            colorCustomizationSection()
        }
        SettingsHorizontalDivider()
        SettingsGroup(title = {
            SettingsTitleTextComponent(text = stringResource(id = com.ncautomation.commons.R.string.general_settings))
        }) {
            generalSection()
        }
    }
}

@Composable
internal fun ColorCustomizationSettingsSection(
    customizeColors: () -> Unit,
    customizeWidgetColors: () -> Unit,
) {
    SettingsPreferenceComponent(
        label = stringResource(id = com.ncautomation.commons.R.string.customize_colors),
        doOnPreferenceClick = customizeColors,
    )
    SettingsPreferenceComponent(
        label = stringResource(id = com.ncautomation.commons.R.string.customize_widget_colors),
        doOnPreferenceClick = customizeWidgetColors
    )
}

@Composable
internal fun GeneralSettingsSection(
    showUseEnglish: Boolean,
    useEnglishChecked: Boolean,
    showDisplayLanguage: Boolean,
    displayLanguage: String,
    turnFlashlightOnStartupChecked: Boolean,
    forcePortraitModeChecked: Boolean,
    showBrightDisplayButtonChecked: Boolean,
    showSosButtonChecked: Boolean,
    showStroboscopeButtonChecked: Boolean,
    onUseEnglishPress: (Boolean) -> Unit,
    onSetupLanguagePress: () -> Unit,
    onTurnFlashlightOnStartupPress: (Boolean) -> Unit,
    onForcePortraitModePress: (Boolean) -> Unit,
    onShowBrightDisplayButtonPress: (Boolean) -> Unit,
    onShowSosButtonPress: (Boolean) -> Unit,
    onShowStroboscopeButtonPress: (Boolean) -> Unit,
) {
    if (showUseEnglish) {
        SettingsCheckBoxComponent(
            label = stringResource(id = com.ncautomation.commons.R.string.use_english_language),
            initialValue = useEnglishChecked,
            onChange = onUseEnglishPress
        )
    }
    if (showDisplayLanguage) {
        SettingsPreferenceComponent(
            label = stringResource(id = com.ncautomation.commons.R.string.language),
            value = displayLanguage,
            doOnPreferenceClick = onSetupLanguagePress
        )
    }
    SettingsCheckBoxComponent(
        label = stringResource(id = R.string.turn_flashlight_on),
        initialValue = turnFlashlightOnStartupChecked,
        onChange = onTurnFlashlightOnStartupPress
    )
    SettingsCheckBoxComponent(
        label = stringResource(id = com.ncautomation.commons.R.string.force_portrait_mode),
        initialValue = forcePortraitModeChecked,
        onChange = onForcePortraitModePress
    )
    SettingsCheckBoxComponent(
        label = stringResource(id = R.string.show_bright_display),
        initialValue = showBrightDisplayButtonChecked,
        onChange = onShowBrightDisplayButtonPress
    )
    SettingsCheckBoxComponent(
        label = stringResource(id = R.string.show_sos),
        initialValue = showSosButtonChecked,
        onChange = onShowSosButtonPress
    )
    SettingsCheckBoxComponent(
        label = stringResource(id = R.string.show_stroboscope),
        initialValue = showStroboscopeButtonChecked,
        onChange = onShowStroboscopeButtonPress
    )
}

@Composable
@MyDevices
private fun SettingsScreenPreview() {
    AppThemeSurface {
        SettingsScreen(
            colorCustomizationSection = {
                ColorCustomizationSettingsSection(
                    customizeColors = {},
                    customizeWidgetColors = {},
                )
            },
            generalSection = {
                GeneralSettingsSection(
                    useEnglishChecked = true,
                    showUseEnglish = true,
                    showDisplayLanguage = true,
                    displayLanguage = "English",
                    turnFlashlightOnStartupChecked = false,
                    forcePortraitModeChecked = true,
                    showBrightDisplayButtonChecked = true,
                    showSosButtonChecked = true,
                    showStroboscopeButtonChecked = true,
                    onUseEnglishPress = {},
                    onSetupLanguagePress = {},
                    onTurnFlashlightOnStartupPress = {},
                    onForcePortraitModePress = {},
                    onShowBrightDisplayButtonPress = {},
                    onShowSosButtonPress = {},
                    onShowStroboscopeButtonPress = {},
                )
            },
            goBack = {},
        )
    }
}

