package com.andresoller.mlsearch.data.remote

import com.andresoller.mlsearch.data.model.SearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MLServiceApi {

    @GET("search")
    fun getProductsSearch(@QueryMap query: HashMap<String, String?>): Observable<SearchResponse>

}