package com.kitur.shop.repository

import com.kitur.shop.api.ApiClient
import com.kitur.shop.api.ApiInterface
import com.kitur.shop.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductRepository {
    private val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getProducts(): Response<ProductResponse>{
        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }
    }
}