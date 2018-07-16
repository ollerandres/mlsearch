package com.andresoller.mlsearch.presentation.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andresoller.mlsearch.R
import com.andresoller.mlsearch.domain.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_product.view.*
import javax.inject.Inject

class ProductAdapter @Inject constructor() : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var products: ArrayList<Product> = ArrayList()
    lateinit var navigationHandler: AdapterNavigationHandler

    interface AdapterNavigationHandler {
        fun navigateToProductDetail(product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false), parent.context)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindItems(products[position], navigationHandler)
    }

    fun updateProducts(products: ArrayList<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    class ProductViewHolder(itemView: View?, val context: Context) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(product: Product, navigationHandler: AdapterNavigationHandler) {
            Picasso.get().load(product.imageUrl).into(itemView.iv_product)
            itemView.tv_title.text = product.title
            itemView.tv_price.text = product.price

            itemView.setOnClickListener { view ->
                navigationHandler.navigateToProductDetail(product)
            }
        }
    }
}