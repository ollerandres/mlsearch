package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class AvailableFiltersItem(

        @field:SerializedName("values")
        val values: List<ValuesItem?>? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("id")
        val id: String? = null,

        @field:SerializedName("type")
        val type: String? = null
)