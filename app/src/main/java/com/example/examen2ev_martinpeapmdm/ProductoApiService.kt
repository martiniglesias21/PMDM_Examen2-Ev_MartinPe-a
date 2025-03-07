package com.example.examen2ev_martinpeapmdm

import com.example.examen2ev_martinpeapmdm.model.ProductoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ProductoApiService {

    @GET
    suspend fun getAllProductos(@Url url: String): Response<ProductoResponse>

}