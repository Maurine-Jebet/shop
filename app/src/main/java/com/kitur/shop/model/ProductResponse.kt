package com.kitur.shop.model

import com.kitur.shop.model.Product

data class ProductResponse (
    var products:List<Product>,
    var total:Int,
    var skip:Int,
    var limit:Int
        )
