package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class Shipping(

        @field:SerializedName("mode")
        val mode: String? = null,

        @field:SerializedName("free_shipping")
        val freeShipping: Boolean? = null,

        @field:SerializedName("tags")
        val tags: List<Any?>? = null,

        @field:SerializedName("logistic_type")
        val logisticType: String? = null
)