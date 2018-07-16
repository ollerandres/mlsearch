package com.andresoller.mlsearch.presentation.utils

import android.net.ConnectivityManager
import android.util.Log
import javax.inject.Inject


class NetworkHelper @Inject constructor(val connectivityManager: ConnectivityManager) {

    fun isDeviceConnected(): Boolean {
        try {
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isAvailable && networkInfo.isConnected
        } catch (e: Exception) {
            Log.v("connectivity", e.toString())
        }

        return false
    }
}