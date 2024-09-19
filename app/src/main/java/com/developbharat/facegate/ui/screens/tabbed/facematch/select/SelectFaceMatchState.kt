package com.developbharat.facegate.ui.screens.tabbed.facematch.select

import com.developbharat.facegate.common.ResourceStatus
import com.developbharat.facegate.domain.models.Person

data class SelectFaceMatchState(
    val status: ResourceStatus = ResourceStatus(),
    val people: List<Person> = emptyList(),
)
