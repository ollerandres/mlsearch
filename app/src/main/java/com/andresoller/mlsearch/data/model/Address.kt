package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class Address(

        @field:SerializedName("city_name")
        val cityName: String? = null,

        @field:SerializedName("state_name")
        val stateName: String? = null,

        @field:SerializedName("state_id")
        val stateId: String? = null,

        @field:SerializedName("city_id")
        val cityId: String? = null
)