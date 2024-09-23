package com.developbharat.facegate.ui.screens.tabbed.searchface

import com.developbharat.facegate.common.ResourceStatus
import com.developbharat.facegate.domain.models.FrameFaceMatchStatus

data class SearchFaceState(
    val match: FrameFaceMatchStatus? = null,
    val status: ResourceStatus = ResourceStatus(),
    val isScanPaused: Boolean = false,
)
