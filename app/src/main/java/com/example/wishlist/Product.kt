package com.example.wishlist

data class Product(val name: String,
                   val price: String,
                   val url: String) {

    companion object {

        fun createProductList(): List<Product> {
            val products = listOf<Product>(
                Product("Mug", "5.99", "11"),
                Product("Shoe", "20.99", "www.buyshoehere.com/shoe")
                )
            return products
        }
    }

}