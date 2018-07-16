package com.andresoller.mlsearch.presentation.di

import android.content.Context
import android.net.ConnectivityManager
import com.andresoller.mlsearch.presentation.MLApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule(private val application: MLApplication) {

    @Provides
    @Singleton
    fun provideConnectivityManager(): ConnectivityManager {
        return application.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}