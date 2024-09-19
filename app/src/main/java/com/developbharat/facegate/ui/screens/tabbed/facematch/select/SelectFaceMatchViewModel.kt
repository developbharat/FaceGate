package com.developbharat.facegate.ui.screens.tabbed.facematch.select

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.domain.uses.batch.ListBatchPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel()
class SelectFaceMatchViewModel @Inject constructor(
    listBatchPeopleUseCase: ListBatchPeopleUseCase
) : ViewModel() {
    private val _state = mutableStateOf(SelectFaceMatchState())
    val state: State<SelectFaceMatchState> = _state

    init {
        listBatchPeopleUseCase().onEach {
            if (it is Resource.ResourceSuccess)
                _state.value = _state.value.copy(status = it.status, people = it.data!!)
            else
                _state.value = _state.value.copy(status = it.status)
        }.launchIn(viewModelScope)
    }
}