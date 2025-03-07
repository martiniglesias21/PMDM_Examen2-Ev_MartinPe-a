package com.example.examen2ev_martinpeapmdm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val images: List<String>) : RecyclerView.Adapter<ProductsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductsViewHolder(layoutInflater.inflate(R.layout.itemproductos, parent, false ))
    }

    override fun getItemCount(): Int {
        return this.images.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val item = this.images[position]
        holder.bind(item)
    }

}