package com.andresoller.mlsearch.presentation

import android.app.Application
import com.andresoller.mlsearch.presentation.di.*

class MLApplication: Application(), UIComponentProvider {

    lateinit var component: MLApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerMLApplicationComponent
                .builder()
                .uIModule(UIModule(this))
                .build()
    }

    override fun getUIComponent(): UIComponent {
        return component.getUIComponent()
    }
}