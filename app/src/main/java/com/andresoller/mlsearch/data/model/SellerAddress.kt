package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class SellerAddress(

        @field:SerializedName("country")
        val country: Country? = null,

        @field:SerializedName("address_line")
        val addressLine: String? = null,

        @field:SerializedName("city")
        val city: City? = null,

        @field:SerializedName("latitude")
        val latitude: String? = null,

        @field:SerializedName("comment")
        val comment: String? = null,

        @field:SerializedName("id")
        val id: String? = null,

        @field:SerializedName("state")
        val state: State? = null,

        @field:SerializedName("zip_code")
        val zipCode: String? = null,

        @field:SerializedName("longitude")
        val longitude: String? = null
)