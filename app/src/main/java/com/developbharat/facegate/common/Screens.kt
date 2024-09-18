package com.developbharat.facegate.common

import kotlinx.serialization.Serializable


@Serializable
sealed interface Screens {
    @Serializable
    data object SetActiveBatchScreen : Screens

    @Serializable
    data object CreateBatchScreen : Screens

}

@Serializable
sealed interface TabbedScreens {
    @Serializable
    data object HomeScreen : Screens

    @Serializable
    data object AttendanceScreen : Screens

    @Serializable
    data object SearchFaceScreen : Screens

    @Serializable
    data object VerificationScreen : Screens
}