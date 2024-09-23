package com.developbharat.facegate.ui.screens.batch.create

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developbharat.facegate.domain.models.Batch
import com.developbharat.facegate.domain.uses.batch.CreateBatchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CreateBatchViewModel @Inject constructor(
    private val createBatchUseCase: CreateBatchUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CreateBatchState())
    val state: State<CreateBatchState> = _state


    fun createBatch(name: String, description: String) {
        val batch = Batch(name = name, description = description)
        createBatchUseCase(batch).onEach {
            _state.value = _state.value.copy(status = it.status)
        }.launchIn(viewModelScope)
    }
}