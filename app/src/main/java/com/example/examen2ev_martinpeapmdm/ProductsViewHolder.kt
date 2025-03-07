package com.example.examen2ev_martinpeapmdm

import android.view.View
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView
import com.example.examen2ev_martinpeapmdm.databinding.ItemproductosBinding
import com.squareup.picasso.Picasso


class ProductsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemproductosBinding.bind(view)

    fun bind(image: String){
        Picasso.get().load(image).into(binding.ivProduct)
    }

}