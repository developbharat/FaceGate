package com.developbharat.facegate.domain.repos.device

import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.core.content.ContextCompat
import com.developbharat.facegate.domain.models.settings.AdvancedOptions
import com.developbharat.facegate.domain.models.settings.AttendanceSheetOptions
import com.developbharat.facegate.domain.models.settings.FaceMatchOptions
import com.developbharat.facegate.domain.models.settings.GlobalOptions
import javax.inject.Inject

class DeviceState @Inject constructor(private val context: Context) : IDeviceState {
    override fun isInternetConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = cm.activeNetwork ?: return false
        val actNw = cm.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            //for other device how are able to connect with Ethernet
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            //for check internet over Bluetooth
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

    override fun isCameraPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun useGlobalOptions(): GlobalOptions {
        return GlobalOptions()
//        TODO("Not yet implemented")
    }

    override fun setGlobalOptions(options: GlobalOptions) {
        TODO("Not yet implemented")
    }

    override fun useAdvancedOptions(): AdvancedOptions {
        TODO("Not yet implemented")
    }

    override fun useAttendanceSheetOptions(): AttendanceSheetOptions {
        TODO("Not yet implemented")
    }

    override fun useFaceMatchOptions(): FaceMatchOptions {
        TODO("Not yet implemented")
    }
}