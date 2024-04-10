package com.example.waveoffood.adapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.waveoffood.DetailsActivity
import com.example.waveoffood.databinding.PopularItemBinding

class PopularAdapter ( private val items:List<String>,private val price :List<String>, private val image: List<Int>, private val  requireContext:Context) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

        override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {

            val item = items[position]
            val image= image[position]
            val price=price[position]
            holder.bind(item,price,image)


            holder.itemView.setOnClickListener{
                val intent= Intent(requireContext, DetailsActivity::class.java)
                intent.putExtra("MenuItemName", item)
                intent.putExtra("MenuItemImage", image)


                requireContext.startActivity(intent)
            }
    }
    override fun getItemCount(): Int {
        return items.size
    }


    class PopularViewHolder (private val binding:PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageView= binding.imageView6
        fun bind(item: String,price: String, image: Int) {
            binding.foodNamePopular.text=item
            binding.PricePopular.text= price
            imageView.setImageResource(image)
        }

    }

}