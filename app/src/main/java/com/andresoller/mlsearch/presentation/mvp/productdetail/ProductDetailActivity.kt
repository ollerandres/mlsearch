package com.andresoller.mlsearch.presentation.mvp.productdetail

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.andresoller.mlsearch.R
import com.andresoller.mlsearch.domain.model.Product
import com.andresoller.mlsearch.presentation.MLApplication
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.content_product_detail.*
import kotlinx.android.synthetic.main.error_message.*
import javax.inject.Inject

class ProductDetailActivity : AppCompatActivity(), ProductDetailView {

    @Inject
    lateinit var presenter: ProductDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MLApplication).getUIComponent().inject(this)
        setContentView(R.layout.activity_product_detail)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            presenter.shareProduct()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter.view = this
        presenter.loadProductDetails()
    }

    override fun loadProductDetails(imageUrl: String, title: String, price: String, acceptsMercadopago: String, cityName: String?, condition: String?, freeShipping: String, ratingAverage: Double?, stateName: String?, countryName: String?) {
        Picasso.get().load(imageUrl).into(iv_product)
        this.title = title
        tv_city.text = cityName
        tv_condition.text = condition
        tv_country.text = countryName
        tv_free_shipping.text = freeShipping
        tv_mercadopago.text = acceptsMercadopago
        tv_state.text = stateName
        tv_rating.text = ratingAverage.toString()
        tv_title.text = title
        tv_price.text = price
    }

    override fun shareProduct(url: String) {
        try {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_SUBJECT, "MLSearch")
            i.putExtra(Intent.EXTRA_TEXT, "Recomiendo que mires este producto que podria interesarte: " + url)
            startActivity(Intent.createChooser(i, "Comparte"))
        } catch (e: Exception) {

        }
    }

    override fun getProduct(): Product {
        return intent.getParcelableExtra("product_extra")
    }
}
