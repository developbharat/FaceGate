package com.developbharat.facegate.ui.screens.settings

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.developbharat.facegate.domain.models.settings.AdvancedOptions
import com.developbharat.facegate.domain.models.settings.AttendanceSheetOptions
import com.developbharat.facegate.domain.models.settings.FaceMatchOptions
import com.developbharat.facegate.domain.models.settings.GlobalOptions
import com.developbharat.facegate.domain.uses.settings.SetAdvancedOptionsUseCase
import com.developbharat.facegate.domain.uses.settings.SetAttendanceSheetOptionsUseCase
import com.developbharat.facegate.domain.uses.settings.SetFaceMatchOptionsUseCase
import com.developbharat.facegate.domain.uses.settings.SetGlobalOptionsUseCase
import com.developbharat.facegate.domain.uses.settings.UseAdvancedOptionsUseCase
import com.developbharat.facegate.domain.uses.settings.UseAttendanceSheetOptionsUseCase
import com.developbharat.facegate.domain.uses.settings.UseFaceMatchOptionsUseCase
import com.developbharat.facegate.domain.uses.settings.UseGlobalOptionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    useGlobalOptionsUseCase: UseGlobalOptionsUseCase,
    useAdvancedOptionsUseCase: UseAdvancedOptionsUseCase,
    useAttendanceSheetOptionsUseCase: UseAttendanceSheetOptionsUseCase,
    useFaceMatchOptionsUseCase: UseFaceMatchOptionsUseCase,
    private val setGlobalOptionsUseCase: SetGlobalOptionsUseCase,
    private val setAdvancedOptionsUseCase: SetAdvancedOptionsUseCase,
    private val setAttendanceSheetOptionsUseCase: SetAttendanceSheetOptionsUseCase,
    private val setFaceMatchOptionsUseCase: SetFaceMatchOptionsUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(
        SettingsScreenState(
            globalOptions = useGlobalOptionsUseCase(),
            advancedOptions = useAdvancedOptionsUseCase(),
            faceMatchOptions = useFaceMatchOptionsUseCase(),
            attendanceSheetOptions = useAttendanceSheetOptionsUseCase()
        )
    )
    val state: State<SettingsScreenState> = _state

    fun updateGlobalOptions(options: GlobalOptions) {
        setGlobalOptionsUseCase(options)
        _state.value = _state.value.copy(globalOptions = options)
    }

    fun updateAdvancedOptions(options: AdvancedOptions) {
        setAdvancedOptionsUseCase(options)
        _state.value = _state.value.copy(advancedOptions = options)
    }

    fun updateAttendanceSheetOptions(options: AttendanceSheetOptions) {
        setAttendanceSheetOptionsUseCase(options)
        _state.value = _state.value.copy(attendanceSheetOptions = options)
    }

    fun updateFaceMatchOptions(options: FaceMatchOptions) {
        setFaceMatchOptionsUseCase(options)
        _state.value = _state.value.copy(faceMatchOptions = options)
    }
}