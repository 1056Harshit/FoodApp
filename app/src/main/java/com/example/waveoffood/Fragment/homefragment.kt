package com.example.waveoffood.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.waveoffood.MenuBottomSheetFragment
import com.example.waveoffood.R
import com.example.waveoffood.adapter.PopularAdapter
import com.example.waveoffood.databinding.FragmentHomeBinding

class homefragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.ViewAllMenu.setOnClickListener{
            val bottomSheetDialog=MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val imageList=ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,scaleType = ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,scaleType = ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,scaleType = ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner4,scaleType = ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner5,scaleType = ScaleTypes.FIT))


        val imageSlider=binding.imageSlider
        imageSlider.setImageList(imageList)

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
            val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })

        val foodName = listOf("Herbal Pancake","Green Salad","Ice Cream","Soup","Fruit Salad")
        val Price= listOf("Rs.260","Rs.350","Rs.70","Rs.50","Rs.200")
        val popularFoodImages= listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu7)
        val adapter=PopularAdapter(foodName,Price,popularFoodImages,requireContext())
        binding.PopularRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.PopularRecyclerView.adapter=adapter
    }

    companion object{

    }
}

