package com.andresoller.mlsearch.presentation.mvp.search

import com.andresoller.mlsearch.domain.interactors.GetProductsInteractor
import com.andresoller.mlsearch.domain.interactors.ProductsInteractorCallback
import com.andresoller.mlsearch.domain.model.Product
import javax.inject.Inject

class SearchPresenter @Inject constructor(private val interactor: GetProductsInteractor) : ProductsInteractorCallback {

    lateinit var view: SearchView

    fun getProducts(query: String?) {
        interactor.getProducts(query, this)
    }

    override fun onSuccess(products: ArrayList<Product>) {
        view.setProducts(products)
    }

    override fun onError(message: String) {
        view.hideSearchView()
        view.displayErrorBanner(message)
    }

    override fun onEmptyResponse() {
        view.hideSearchView()
        view.displayNoProductsBanner()
    }

    override fun onEmptyQuery() {
        view.hideSearchView()
        view.displayEmptyQuery()
    }

    override fun onDeviceNotConnected() {
        view.hideSearchView()
        view.displayDeviceNotConnected()
    }
}