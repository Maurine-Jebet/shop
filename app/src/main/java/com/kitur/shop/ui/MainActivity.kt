package com.kitur.shop.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop2.ProductAdapter
import com.kitur.shop.databinding.ActivityMainBinding
import com.kitur.shop.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {
    private val productViewModel: ProductViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        productViewModel.fetchProducts()
        productViewModel.productLiveData.observe(this, Observer { productList->
            var productAdapter = ProductAdapter(productList ?: emptyList())
            binding.rvProduct.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvProduct.adapter = productAdapter
            Toast.makeText(baseContext, "fetched ${productList?.size} products", Toast.LENGTH_LONG).show()
        })

        productViewModel.errorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }


}