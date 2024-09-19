package com.developbharat.facegate.domain.models.settings

data class GlobalOptions(
    val modelReleaseVersion: String = "1.0",
    val selectedBatchId: String? = null,
)