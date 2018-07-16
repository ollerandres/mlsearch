package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class Paging(

        @field:SerializedName("total")
        val total: Int? = null,

        @field:SerializedName("offset")
        val offset: Int? = null,

        @field:SerializedName("limit")
        val limit: Int? = null,

        @field:SerializedName("primary_results")
        val primaryResults: Int? = null
)