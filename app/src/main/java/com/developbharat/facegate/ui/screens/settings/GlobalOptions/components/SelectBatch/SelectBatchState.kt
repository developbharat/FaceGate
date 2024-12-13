package com.developbharat.facegate.ui.screens.settings.GlobalOptions.components.SelectBatch

import com.developbharat.facegate.common.ResourceStatus
import com.developbharat.facegate.domain.models.Batch

data class SelectBatchState(
    val status: ResourceStatus = ResourceStatus(),
    val batches: List<Batch> = emptyList()
)