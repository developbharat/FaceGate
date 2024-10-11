package com.developbharat.facegate.ui.screens.tabbed.facematch.scan

import com.developbharat.facegate.common.ResourceStatus
import com.developbharat.facegate.domain.models.Person
import com.developbharat.facegate.domain.repos.facedb.PersonFaceData

data class ScanFaceMatchState(
    val status: ResourceStatus = ResourceStatus(),
    val selectedPerson: Person,
    val match: PersonFaceData? = null,
)