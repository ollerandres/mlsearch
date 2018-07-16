package com.andresoller.mlsearch.domain.interactors

import com.andresoller.mlsearch.domain.model.Product

interface ProductsInteractorCallback {

    fun onSuccess(products: ArrayList<Product>)

    fun onError(message: String)

    fun onEmptyResponse()

    fun onEmptyQuery()

    fun onDeviceNotConnected()
}
