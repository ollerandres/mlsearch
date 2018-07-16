package com.andresoller.mlsearch.data.remote

import com.andresoller.mlsearch.data.model.SearchResponse
import io.reactivex.Observable
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val service: MLServiceApi) {

    fun getProducts(query: HashMap<String, String?>): Observable<SearchResponse> {
        return service.getProductsSearch(query)
    }
}