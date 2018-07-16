package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class Installments(

        @field:SerializedName("amount")
        val amount: Double? = null,

        @field:SerializedName("quantity")
        val quantity: Int? = null,

        @field:SerializedName("rate")
        val rate: Double? = null,

        @field:SerializedName("currency_id")
        val currencyId: String? = null
)