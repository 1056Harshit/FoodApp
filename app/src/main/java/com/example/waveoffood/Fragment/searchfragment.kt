package com.example.waveoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waveoffood.R
import com.example.waveoffood.adapter.MenuAdapter
import com.example.waveoffood.databinding.FragmentSearchBinding


class searchfragment : Fragment() {

    private lateinit var binding:FragmentSearchBinding
    private lateinit var  adapter:MenuAdapter
    private val originalMenuFoodName= listOf("Herbal Pancake", "Green Salad", "Ice Cream", "Soup","Fruit Chatt","Peri Peri Fries", "Ice Cream", "Soup","Fruit Chatt","Peri Peri Fries","Burger","Momos")

    val originalMenuItemPrice = listOf("Rs.260", "Rs.350", "Rs.70", "Rs.50","130","100", "Rs.70", "Rs.50","130","100","60","45")

    val originalMenuImage = listOf(
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val filteredMenuFoodName= mutableListOf<String>()
    private val filteredMenuItemPrice= mutableListOf<String>()
    private val filteredMenuImage= mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSearchBinding.inflate(inflater,container,false)
        adapter=MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage,requireContext())
        binding.menuRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter


        //setup for search view
        setupSearchView()

        //show All menu items

        ShowAllMenu()



        return binding.root
    }

    private fun ShowAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)


        adapter.notifyDataSetChanged()

    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

        })

    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()


        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }

        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}

