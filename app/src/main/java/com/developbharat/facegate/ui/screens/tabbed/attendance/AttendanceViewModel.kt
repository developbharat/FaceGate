package com.developbharat.facegate.ui.screens.tabbed.attendance

import android.content.Context
import android.content.pm.PackageManager
import androidx.camera.core.ImageProxy
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.common.toRotatedBitmap
import com.developbharat.facegate.domain.uses.attendance.MarkAttendanceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Timer
import javax.inject.Inject
import kotlin.concurrent.schedule

@HiltViewModel
class AttendanceViewModel @Inject constructor(
    private val markAttendanceUseCase: MarkAttendanceUseCase
) : ViewModel() {
    private val _state = mutableStateOf(AttendanceState())
    val state: State<AttendanceState> = _state


    fun setIsScanPaused(shallPause: Boolean) {
        if (state.value.isScanPaused == shallPause) return

        if (shallPause)
            _state.value = _state.value.copy(isScanPaused = true)
        else
            _state.value = _state.value.copy(isScanPaused = false, match = null)
    }


    fun executeScanOperation(frame: ImageProxy) {
        if (state.value.status.isInProgress || state.value.isScanPaused) {
            frame.close()
            return
        }

        markAttendanceUseCase(frame.toRotatedBitmap()).onEach {
            if (it is Resource.ResourceSuccess) {
                _state.value =
                    _state.value.copy(match = it.data, status = it.status, isScanPaused = true)
                // Pause scan for 2 seconds
                Timer().schedule(2000) { setIsScanPaused(false) }
                frame.close()
            } else {
                _state.value = _state.value.copy(match = null, status = it.status)
                frame.close()
            }
        }.launchIn(viewModelScope)
    }


    fun checkAndUpdateCameraPermission(context: Context) {
        val isGranted = isCameraPermissionGranted(context)
        _state.value = _state.value.copy(isCameraPermissionGranted = isGranted)
    }

    private fun isCameraPermissionGranted(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context, android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }
}