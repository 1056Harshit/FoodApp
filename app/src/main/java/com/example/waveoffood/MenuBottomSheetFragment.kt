package com.example.waveoffood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waveoffood.adapter.MenuAdapter
import com.example.waveoffood.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment()
{
    private lateinit var binding:FragmentMenuBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener{
            dismiss()
        }
        val menuFoodName = listOf("Herbal Pancake", "Green Salad", "Ice Cream", "Soup","Fruit Chatt","Peri Peri Fries", "Ice Cream", "Soup","Fruit Chatt","Peri Peri Fries")
        val menuItemPrice = listOf("Rs.260", "Rs.350", "Rs.70", "Rs.50","Rs.130","Rs.100", "Rs.70", "Rs.50","Rs.130","Rs.100")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu7,
            R.drawable.menu5,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu7,
            R.drawable.menu5,
        )
        val adapter =
            MenuAdapter(ArrayList(menuFoodName), ArrayList(menuItemPrice), ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }


    companion object {

    }
}