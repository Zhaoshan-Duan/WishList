package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter : RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

    var data = listOf<Product>()
        set(value) {
            field = value
            //TODO: Improve this with DiffUtil
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size

    class ViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {
        val nameTv = view.findViewById<TextView>(R.id.tv_item_name)
        val priceTv = view.findViewById<TextView>(R.id.tv_price)
        val urlTv = view.findViewById<TextView>(R.id.tv_url)

        fun bind(item: Product) {
            apply {
                nameTv.text = item.name
                priceTv.text = item.price
                urlTv.text = item.url
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_product, parent, false)
                return ViewHolder(view)
            }
        }

    }
}