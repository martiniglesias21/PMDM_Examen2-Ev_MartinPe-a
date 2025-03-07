package com.example.examen2ev_martinpeapmdm

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen2ev_martinpeapmdm.databinding.ActivityMainBinding
import com.example.examen2ev_martinpeapmdm.model.Producto
import com.example.examen2ev_martinpeapmdm.model.ProductoResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var adapter : ProductAdapter
    private val productsImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        this.fetchData("products")
        this.initRecyclerView()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initRecyclerView() {
        adapter = ProductAdapter(productsImages)
        binding.rvProductos.layoutManager = LinearLayoutManager(this)
        binding.rvProductos.adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://peticiones.online/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun fetchData(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<ProductoResponse> = getRetrofit()
                .create(ProductoApiService::class.java).getAllProductos(query)

            val producto: ProductoResponse? = call.body()

            if (call.isSuccessful){
                if (producto != null) {
                    for (miProducto: Producto in producto.results){
                        Log.v("Producto Query", miProducto.image)
                    }
                } else {
                    Log.e("Producto Query", "Ha habido un error en el proceso")
                    showError("Un error ha ocurrido")
                }
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}