package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class Reviews(

        @field:SerializedName("rating_average")
        val ratingAverage: Double? = null,

        @field:SerializedName("total")
        val total: Int? = null
)