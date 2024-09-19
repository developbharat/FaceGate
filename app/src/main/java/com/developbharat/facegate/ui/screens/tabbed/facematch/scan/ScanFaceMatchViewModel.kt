package com.developbharat.facegate.ui.screens.tabbed.facematch.scan

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.developbharat.facegate.common.TabbedScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScanFaceMatchViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state =
        mutableStateOf(
            ScanFaceMatchState(
                selectedPerson = TabbedScreens.ScanFaceMatchScreen.from(savedStateHandle)
            )
        )
    val state: State<ScanFaceMatchState> = _state
}