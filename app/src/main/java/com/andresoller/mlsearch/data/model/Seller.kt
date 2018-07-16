package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class Seller(

        @field:SerializedName("power_seller_status")
        val powerSellerStatus: String? = null,

        @field:SerializedName("car_dealer")
        val carDealer: Boolean? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("real_estate_agency")
        val realEstateAgency: Boolean? = null,

        @field:SerializedName("tags")
        val tags: List<Any?>? = null
)