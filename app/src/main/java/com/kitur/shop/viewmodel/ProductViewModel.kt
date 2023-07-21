package com.kitur.shop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitur.shop.model.Product
import com.kitur.shop.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel:ViewModel() {
        private var productRepo = ProductRepository()
        val productLiveData = MutableLiveData<List<Product>>()
        val errorLiveData =MutableLiveData<String>()

        fun fetchProducts(){
            viewModelScope.launch{
                val response = productRepo.getProducts()
                if (response.isSuccessful){
                    productLiveData.postValue(response.body()?.products)
                }
                else{
                    errorLiveData.postValue(response.errorBody()?.string())
                }
            }
        }


}