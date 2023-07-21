
package com.example.myshop2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.kitur.shop.model.Product
import com.kitur.shop.databinding.ProductDisplayBinding



class ProductAdapter (var productList:List<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var binding=ProductDisplayBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var currentProduct = productList[position]
        holder.bind(currentProduct)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(private val binding: ProductDisplayBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(currentProduct: Product){
            binding.apply {
                binding.tvId.text = currentProduct.id.toString()
                binding.tvTitle.text = currentProduct.title.toString()
                binding.tvDescription.text = currentProduct.description.toString()
                binding.tvPrice.text = currentProduct.price.toString()
                binding.tvRatings.text = currentProduct.rating.toString()
                binding.tvStock.text = currentProduct.stock.toString()
                binding.tvCategory.text = currentProduct.category.toString()

                Picasso.get()
                    .load(currentProduct.thumbnail)
                    .into(binding.ivImage)
            }
        }
    }
}

