package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class ValuesItem(

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("path_from_root")
        val pathFromRoot: List<PathFromRootItem?>? = null,

        @field:SerializedName("id")
        val id: String? = null
)