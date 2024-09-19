package com.developbharat.facegate.domain.repos.device

interface IDeviceState {
    fun isInternetConnected(): Boolean
    fun isCameraPermissionGranted(): Boolean
}