package com.andresoller.mlsearch.presentation.di

import com.andresoller.mlsearch.data.di.DataModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(UIModule::class),
    (DataModule::class)])
interface MLApplicationComponent {
    fun getUIComponent(): UIComponent
}