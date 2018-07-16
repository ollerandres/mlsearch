package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class Sort(

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("id")
        val id: String? = null
)