package com.andresoller.mlsearch.presentation.di

import com.andresoller.mlsearch.presentation.mvp.productdetail.ProductDetailActivity
import com.andresoller.mlsearch.presentation.mvp.search.SearchActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Subcomponent
interface UIComponent {

    fun inject(activity: SearchActivity)

    fun inject(activity: ProductDetailActivity)
}
