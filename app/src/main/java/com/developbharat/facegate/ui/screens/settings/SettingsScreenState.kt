package com.developbharat.facegate.ui.screens.settings

import com.developbharat.facegate.domain.models.settings.AdvancedOptions
import com.developbharat.facegate.domain.models.settings.AttendanceSheetOptions
import com.developbharat.facegate.domain.models.settings.FaceMatchOptions
import com.developbharat.facegate.domain.models.settings.GlobalOptions

data class SettingsScreenState(
    val globalOptions: GlobalOptions = GlobalOptions(),
    val advancedOptions: AdvancedOptions = AdvancedOptions(),
    val faceMatchOptions: FaceMatchOptions = FaceMatchOptions(),
    val attendanceSheetOptions: AttendanceSheetOptions = AttendanceSheetOptions()
)