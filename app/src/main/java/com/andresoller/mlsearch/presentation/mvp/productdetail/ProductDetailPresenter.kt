package com.andresoller.mlsearch.presentation.mvp.productdetail

import javax.inject.Inject

class ProductDetailPresenter @Inject constructor() {

    lateinit var view: ProductDetailView

    fun loadProductDetails() {
        val product = view.getProduct()
        view.loadProductDetails(product.imageUrl, product.title, product.price, getAcceptsMercadoPago(product.acceptsMercadopago), product.cityName,
                getCondition(product.condition), getFreeShipping(product.freeShipping), product.ratingAverage, product.stateName, product.countryName)
    }

    private fun getAcceptsMercadoPago(acceptsMercadopago: Boolean?): String {
        return if (acceptsMercadopago!!) {
            "SI"
        } else {
            "NO"
        }
    }

    private fun getFreeShipping(freeShipping: Boolean?): String {
        return if (freeShipping!!) {
            "SI"
        } else {
            "NO"
        }
    }

    private fun getCondition(condition: String?): String? {
        return if (condition.equals("new")) {
            "Nuevo"
        } else {
            "Usado"
        }
    }

    fun shareProduct() {
        view.shareProduct(view.getProduct().productUrl)
    }
}
