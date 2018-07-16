package com.andresoller.mlsearch.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Product(val id: String,
                   val title: String,
                   val price: String,
                   val imageUrl: String,
                   val productUrl: String,
                   val condition: String?,
                   val acceptsMercadopago: Boolean?,
                   val availableQuantity: Int?,
                   val freeShipping: Boolean?,
                   val cityName: String?,
                   val stateName: String?,
                   val countryName: String?,
                   val ratingAverage: Double?) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Double::class.java.classLoader) as Double?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(title)
        writeString(price)
        writeString(imageUrl)
        writeString(productUrl)
        writeString(condition)
        writeValue(acceptsMercadopago)
        writeValue(availableQuantity)
        writeValue(freeShipping)
        writeString(cityName)
        writeString(stateName)
        writeString(countryName)
        writeValue(ratingAverage)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Product> = object : Parcelable.Creator<Product> {
            override fun createFromParcel(source: Parcel): Product = Product(source)
            override fun newArray(size: Int): Array<Product?> = arrayOfNulls(size)
        }
    }
}