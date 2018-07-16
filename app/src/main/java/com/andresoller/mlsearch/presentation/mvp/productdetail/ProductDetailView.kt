package com.andresoller.mlsearch.presentation.mvp.productdetail

import com.andresoller.mlsearch.domain.model.Product

interface ProductDetailView {

    fun loadProductDetails(imageUrl: String, title: String, price: String, acceptsMercadopago: String, cityName: String?, condition: String?,
                           freeShipping: String, ratingAverage: Double?, stateName: String?, countryName: String?)

    fun shareProduct(url: String)

    fun getProduct(): Product
}
