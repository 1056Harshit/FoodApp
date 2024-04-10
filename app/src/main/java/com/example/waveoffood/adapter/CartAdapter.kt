package com.example.waveoffood.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.waveoffood.databinding.CartItemBinding

class CartAdapter( private val CartItems:MutableList<String>,private val CartItemPrice:MutableList<String>,private val CartImage:MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities=IntArray(CartItems.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
    holder.bind(position)

    }

    override fun getItemCount(): Int = CartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SuspiciousIndentation")
        fun bind(position: Int) {

            binding.apply {
                val quantity=itemQuantities[position]
                cartFoodName.text=CartItems[position]
                CartitemPrice.text= CartItemPrice[position]
                cartimage.setImageResource(CartImage[position])
                catItemQuantity.text=quantity.toString()



                minusbutton.setOnClickListener {
                    decreaseQuantity(position)
                }

                plusbutton.setOnClickListener {
                    increaseQuality(position)

                }

                deletebutton.setOnClickListener {
                val ItemPosition=adapterPosition
                    if(ItemPosition!=RecyclerView.NO_POSITION){
                        deleteItem(ItemPosition)
                    }
                }
            }
        }

        private fun increaseQuality(position: Int){
            if(itemQuantities[position]<20){
                itemQuantities[position]++
                binding.catItemQuantity.text=itemQuantities[position].toString()
            }
        }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.catItemQuantity.text = itemQuantities[position].toString()
            }
        }

        private  fun deleteItem(position: Int){
            CartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,CartItems.size)
        }

    }

}