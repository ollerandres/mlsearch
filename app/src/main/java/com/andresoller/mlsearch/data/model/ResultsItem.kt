package com.andresoller.mlsearch.data.model

import com.google.gson.annotations.SerializedName

data class ResultsItem(

        @field:SerializedName("seller")
        val seller: Seller? = null,

        @field:SerializedName("original_price")
        val originalPrice: Double? = null,

        @field:SerializedName("stop_time")
        val stopTime: String? = null,

        @field:SerializedName("buying_mode")
        val buyingMode: String? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("sold_quantity")
        val soldQuantity: Int? = null,

        @field:SerializedName("available_quantity")
        val availableQuantity: Int? = null,

        @field:SerializedName("shipping")
        val shipping: Shipping? = null,

        @field:SerializedName("category_id")
        val categoryId: String? = null,

        @field:SerializedName("reviews")
        val reviews: Reviews? = null,

        @field:SerializedName("installments")
        val installments: Installments? = null,

        @field:SerializedName("price")
        val price: Double? = null,

        @field:SerializedName("official_store_id")
        val officialStoreId: Any? = null,

        @field:SerializedName("id")
        val id: String? = null,

        @field:SerializedName("accepts_mercadopago")
        val acceptsMercadopago: Boolean? = null,

        @field:SerializedName("thumbnail")
        val thumbnail: String? = null,

        @field:SerializedName("address")
        val address: Address? = null,

        @field:SerializedName("catalog_product_id")
        val catalogProductId: Any? = null,

        @field:SerializedName("seller_address")
        val sellerAddress: SellerAddress? = null,

        @field:SerializedName("tags")
        val tags: List<String?>? = null,

        @field:SerializedName("condition")
        val condition: String? = null,

        @field:SerializedName("site_id")
        val siteId: String? = null,

        @field:SerializedName("attributes")
        val attributes: List<AttributesItem?>? = null,

        @field:SerializedName("listing_type_id")
        val listingTypeId: String? = null,

        @field:SerializedName("permalink")
        val permalink: String? = null,

        @field:SerializedName("currency_id")
        val currencyId: String? = null
)