package com.example.waveoffood.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waveoffood.CongratsBottomSheet
import com.example.waveoffood.PayOutActivity
import com.example.waveoffood.R
import com.example.waveoffood.adapter.CartAdapter
import com.example.waveoffood.databinding.FragmentCartBinding

class cartfragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName= listOf("Herbal Pancake","Green Salad","Ice Cream","Soup")
        val CartItemPrice= listOf("Rs.260","Rs.350","Rs.70","Rs.50")
        val cartimage= listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
        )
        val adapter=CartAdapter(ArrayList(cartFoodName),ArrayList(CartItemPrice),ArrayList(cartimage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter=adapter

        binding.proceedButton.setOnClickListener {
            val intent=Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }





        return binding.root
    }

}