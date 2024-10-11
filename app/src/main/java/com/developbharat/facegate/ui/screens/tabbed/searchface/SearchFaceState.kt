package com.developbharat.facegate.ui.screens.tabbed.searchface

import com.developbharat.facegate.common.ResourceStatus
import com.developbharat.facegate.domain.repos.facedb.PersonFaceData

data class SearchFaceState(
    val match: PersonFaceData? = null,
    val status: ResourceStatus = ResourceStatus(),
    val isScanPaused: Boolean = false,
)
