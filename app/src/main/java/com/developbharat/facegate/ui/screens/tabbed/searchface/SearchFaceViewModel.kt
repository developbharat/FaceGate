package com.developbharat.facegate.ui.screens.tabbed.searchface

import androidx.camera.core.ImageProxy
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.common.toRotatedBitmap
import com.developbharat.facegate.domain.uses.facematch.SearchFaceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Timer
import javax.inject.Inject
import kotlin.concurrent.schedule

@HiltViewModel
class SearchFaceViewModel @Inject constructor(
    val searchFaceUseCase: SearchFaceUseCase
) : ViewModel() {
    private val _state = mutableStateOf(SearchFaceState())
    val state: State<SearchFaceState> = _state

    fun setIsScanPaused(isPaused: Boolean) {
        if (_state.value.isScanPaused == isPaused) return
        _state.value = _state.value.copy(isScanPaused = isPaused)
    }


    fun searchFaceInCameraFrame(frame: ImageProxy) {
        if (state.value.isScanPaused || state.value.status.isInProgress) {
            frame.close()
            return
        }

        searchFaceUseCase(frame.toRotatedBitmap()).onEach {
            if (it is Resource.ResourceSuccess) {
                // Pause scan and enable after 2 seconds
                _state.value = _state.value.copy(match = it.data, status = it.status, isScanPaused = true)
                Timer().schedule(2000) { setIsScanPaused(false) }
            } else {
                _state.value = _state.value.copy(match = null, status = it.status)
            }

            // close frame
            frame.close()
        }.launchIn(viewModelScope)
    }
}