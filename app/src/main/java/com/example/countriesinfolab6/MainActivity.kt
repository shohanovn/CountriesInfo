package com.example.countriesinfolab6

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val countries = listOf(
            Country("Vietnam", R.mipmap.vn, 98000000),
            Country("United States", R.mipmap.us, 320000000),
            Country("Russia", R.mipmap.ru, 142000000)
        )

        adapter = CountryAdapter(countries) { country ->
            Toast.makeText(
                this,
                "Selected: ${country.name}", // Используем name вместо countryName
                Toast.LENGTH_SHORT
            ).show()
        }
        recyclerView.adapter = adapter
    }
}