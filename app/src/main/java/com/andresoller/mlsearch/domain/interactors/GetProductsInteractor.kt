package com.andresoller.mlsearch.domain.interactors

import com.andresoller.mlsearch.data.model.SearchResponse
import com.andresoller.mlsearch.data.remote.RemoteRepository
import com.andresoller.mlsearch.domain.model.Product
import com.andresoller.mlsearch.presentation.utils.NetworkHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetProductsInteractor @Inject constructor(val networkHelper: NetworkHelper,
                                                val repository: RemoteRepository) {

    fun getProducts(productQueried: String?, callback: ProductsInteractorCallback) {
        if (productQueried.isNullOrEmpty()) {
            callback.onEmptyQuery()
            return
        }

        if (!networkHelper.isDeviceConnected()) {
            callback.onDeviceNotConnected()
            return
        }

        val query = HashMap<String, String?>()
        query["q"] = productQueried

        repository.getProducts(query).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map({ response: SearchResponse ->
                    val products: ArrayList<Product> = ArrayList()
                    for (item in response.results!!) {
                        val product = Product(item!!.id!!,
                                item.title!!,
                                item.price!!.toString() + " " + item.currencyId!!,
                                item.thumbnail!!,
                                item.permalink!!,
                                item.condition,
                                item.acceptsMercadopago,
                                item.availableQuantity,
                                item.shipping!!.freeShipping,
                                item.address!!.cityName,
                                item.address!!.stateName,
                                item.sellerAddress!!.country!!.name,
                                item.reviews!!.ratingAverage)
                        products.add(product)
                    }
                    return@map products
                })
                .subscribe({ response ->
                    if (response.isEmpty()) {
                        callback.onEmptyResponse()
                    } else {
                        callback.onSuccess(response)
                    }
                }, { error ->
                    callback.onError(error.message.toString())
                })
    }
}