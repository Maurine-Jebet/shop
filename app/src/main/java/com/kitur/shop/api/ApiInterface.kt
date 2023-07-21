package com.kitur.shop.api
import com.kitur.shop.model.Product
import com.kitur.shop.model.ProductResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/product")

    suspend fun getProducts():Response<ProductResponse>

    @GET("/product/{id}")
    suspend fun getProductById(@Path("id")productId:Int):Response<Product>

}