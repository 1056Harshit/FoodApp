package com.example.waveoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waveoffood.R
import com.example.waveoffood.adapter.BuyAgainAdapter
import com.example.waveoffood.databinding.FragmentHistoryfragmentBinding


class historyfragment : Fragment() {
    private lateinit var binding: FragmentHistoryfragmentBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHistoryfragmentBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView(){
        val buyAgainFoodName= arrayListOf("Food 1","Food 2","Food 3","Food 4","Food 5")
        val buyAgainFoodPrice= arrayListOf("Rs.260","Rs.70","Rs.350","Rs.50","Rs.200")
        val buyAgainFoodImage= arrayListOf(R.drawable.menu1,R.drawable.menu3,R.drawable.menu2,R.drawable.menu4,R.drawable.menu7)
        buyAgainAdapter=BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.BuyAgainRecyclerView.adapter=buyAgainAdapter
        binding.BuyAgainRecyclerView.layoutManager=LinearLayoutManager(requireContext())
    }


    companion object {

    }
}