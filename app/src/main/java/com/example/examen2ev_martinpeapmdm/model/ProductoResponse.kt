package com.example.examen2ev_martinpeapmdm.model

import com.google.gson.annotations.SerializedName

data class ProductoResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val per_page: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("results") val results: List<Producto>
)