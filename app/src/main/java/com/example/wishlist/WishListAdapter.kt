package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter: RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

    var data = listOf<Product>()
        set(value) {
            field = value
            //TODO: Improve this with DiffUtil
            notifyDataSetChanged()
        }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTv = view.findViewById<TextView>(R.id.tv_item_name)
        val priceTv = view.findViewById<TextView>(R.id.tv_price)
        val urlTv = view.findViewById<TextView>(R.id.tv_url)

    }

    //TODO: Refactor this
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent,false)
        return ViewHolder(view)
    }

    //TODO: Refactor this
    override fun onBindViewHolder(holder: WishListAdapter.ViewHolder, position: Int) {
        val item = data[position]

        holder.apply{
            nameTv.text = item.name
            priceTv.text = item.price
            urlTv.text = item.url
        }
    }


    override fun getItemCount() = data.size
}