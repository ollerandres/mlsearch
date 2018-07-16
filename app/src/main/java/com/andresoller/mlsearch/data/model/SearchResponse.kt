package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(

        @field:SerializedName("available_sorts")
        val availableSorts: List<AvailableSortsItem?>? = null,

        @field:SerializedName("query")
        val query: String? = null,

        @field:SerializedName("available_filters")
        val availableFilters: List<AvailableFiltersItem?>? = null,

        @field:SerializedName("site_id")
        val siteId: String? = null,

        @field:SerializedName("paging")
        val paging: Paging? = null,

        @field:SerializedName("secondary_results")
        val secondaryResults: List<Any?>? = null,

        @field:SerializedName("sort")
        val sort: Sort? = null,

        @field:SerializedName("filters")
        val filters: List<FiltersItem?>? = null,

        @field:SerializedName("results")
        val results: List<ResultsItem?>? = null,

        @field:SerializedName("related_results")
        val relatedResults: List<Any?>? = null
)