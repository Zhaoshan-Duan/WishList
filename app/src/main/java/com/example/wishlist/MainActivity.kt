package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wishlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Set up adapter
        val adapter = WishListAdapter()
        binding.rvProducts.adapter = adapter
        binding.rvProducts.layoutManager = LinearLayoutManager(this)

        val products = mutableListOf<Product>()

        binding.button.setOnClickListener {
            with(binding) {
                val newProduct = Product(
                    etItemName.text.toString(),
                    etPrice.text.toString(),
                    etUrl.text.toString()
                )
                products.add(newProduct)

                etItemName.text?.clear()
                etPrice.text?.clear()
                etUrl.text?.clear()
            }

            adapter.data = products
        }
    }

}