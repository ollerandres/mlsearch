package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName
import java.math.BigInteger

data class AttributesItem(

        @field:SerializedName("attribute_group_id")
        val attributeGroupId: String? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("attribute_group_name")
        val attributeGroupName: String? = null,

        @field:SerializedName("value_id")
        val valueId: String? = null,

        @field:SerializedName("value_struct")
        val valueStruct: Any? = null,

        @field:SerializedName("source")
        val source: BigInteger? = null,

        @field:SerializedName("id")
        val id: String? = null,

        @field:SerializedName("value_name")
        val valueName: String? = null
)