package com.developbharat.facegate.domain.repos.device

import com.developbharat.facegate.domain.models.settings.AdvancedOptions
import com.developbharat.facegate.domain.models.settings.AttendanceSheetOptions
import com.developbharat.facegate.domain.models.settings.FaceMatchOptions
import com.developbharat.facegate.domain.models.settings.GlobalOptions

interface IDeviceState {
    fun isInternetConnected(): Boolean
    fun isCameraPermissionGranted(): Boolean

    // Related to application settings
    fun useGlobalOptions(): GlobalOptions
    fun setGlobalOptions(options: GlobalOptions)
    fun useAdvancedOptions(): AdvancedOptions
    fun useAttendanceSheetOptions(): AttendanceSheetOptions
    fun useFaceMatchOptions(): FaceMatchOptions
}