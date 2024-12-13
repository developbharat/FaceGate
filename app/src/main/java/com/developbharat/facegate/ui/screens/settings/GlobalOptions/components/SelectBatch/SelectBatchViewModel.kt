package com.developbharat.facegate.ui.screens.settings.GlobalOptions.components.SelectBatch

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.domain.uses.batch.ListBatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SelectBatchViewModel @Inject constructor(
    val listBatchesUseCase: ListBatchesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(SelectBatchState())
    val state: State<SelectBatchState> = _state


    init {
        loadBatches()
    }

    fun loadBatches() {
        listBatchesUseCase().onEach {
            if (it is Resource.ResourceSuccess) {
                _state.value = _state.value.copy(status = it.status, batches = it.data ?: emptyList())
            } else {
                _state.value = _state.value.copy(status = it.status)
            }
        }.launchIn(viewModelScope)
    }
}