package com.andresoller.mlsearch.presentation.mvp.search

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView.OnQueryTextListener
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import com.andresoller.mlsearch.R
import com.andresoller.mlsearch.domain.model.Product
import com.andresoller.mlsearch.presentation.MLApplication
import com.andresoller.mlsearch.presentation.adapters.ProductAdapter
import com.andresoller.mlsearch.presentation.adapters.ProductAdapter.AdapterNavigationHandler
import com.andresoller.mlsearch.presentation.mvp.productdetail.ProductDetailActivity
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.error_empty_query.*
import kotlinx.android.synthetic.main.error_message.*
import kotlinx.android.synthetic.main.error_no_connection.*
import kotlinx.android.synthetic.main.error_no_results.*
import kotlinx.android.synthetic.main.item_product.*
import javax.inject.Inject


class SearchActivity : AppCompatActivity(), SearchView, OnQueryTextListener, AdapterNavigationHandler {

    @Inject
    lateinit var presenter: SearchPresenter

    @Inject
    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MLApplication).getUIComponent().inject(this)
        presenter.view = this
        setContentView(R.layout.activity_search)

        sv_products.setOnQueryTextListener(this)
        adapter.navigationHandler = this
        recycler_products.layoutManager = LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)
        recycler_products.adapter = adapter

        btn_error_empty_query.setOnClickListener {
            error_empty_query_layout.visibility = GONE
            showSearchView()
        }
        btn_error_message.setOnClickListener {
            error_message_layout.visibility = GONE
            showSearchView()
        }
        btn_error_no_connection.setOnClickListener {
            error_no_connection_layout.visibility = GONE
            showSearchView()
        }
        btn_error_no_results.setOnClickListener {
            error_no_results_layout.visibility = GONE
            showSearchView()
        }
    }

    override fun setProducts(products: ArrayList<Product>) {
        adapter.updateProducts(products)
    }

    override fun displayErrorBanner(message: String) {
        tv_error_message.text = message
        error_empty_query_layout.visibility = VISIBLE

    }

    override fun displayNoProductsBanner() {
        error_no_results_layout.visibility = VISIBLE
    }

    override fun displayEmptyQuery() {
        error_empty_query_layout.visibility = VISIBLE
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        presenter.getProducts(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        // NO-OP
        return true
    }

    override fun navigateToProductDetail(product: Product) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, iv_product, "profile")
        startActivity(Intent(this, ProductDetailActivity::class.java)
                .putExtra("product_extra", product), options.toBundle())
    }

    override fun displayDeviceNotConnected() {
        error_no_connection_layout.visibility = VISIBLE
    }

    override fun hideSearchView() {
        sv_products.visibility = GONE
    }

    override fun showSearchView() {
        sv_products.visibility = VISIBLE
    }
}
