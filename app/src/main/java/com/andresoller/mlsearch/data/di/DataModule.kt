package com.andresoller.mlsearch.data.di

import com.andresoller.mlsearch.data.remote.MLServiceApi
import dagger.Module
import dagger.Provides
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {

    val BASE_URL = "https://api.mercadolibre.com/sites/MLA/"

    @Provides
    fun provideMLServiceApi(): MLServiceApi {
        val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

        return retrofit.create(MLServiceApi::class.java)
    }
}