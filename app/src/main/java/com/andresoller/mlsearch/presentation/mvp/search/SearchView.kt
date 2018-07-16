package com.andresoller.mlsearch.presentation.mvp.search

import com.andresoller.mlsearch.domain.model.Product

interface SearchView {

    fun setProducts(products: ArrayList<Product>)

    fun displayErrorBanner(message: String)

    fun displayNoProductsBanner()

    fun displayEmptyQuery()

    fun displayDeviceNotConnected()

    fun hideSearchView()

    fun showSearchView()
}