package com.developbharat.facegate.ui.screens.tabbed.facematch.scan

import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.developbharat.facegate.common.TabbedScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScanFaceMatchViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _state = mutableStateOf(
        ScanFaceMatchState(
            selectedPerson = TabbedScreens.ScanFaceMatchScreen.from(savedStateHandle).person
        )
    )
    val state: State<ScanFaceMatchState> = _state


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