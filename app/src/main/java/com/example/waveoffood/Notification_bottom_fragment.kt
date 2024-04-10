package com.example.waveoffood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waveoffood.adapter.NotificationAdapter
import com.example.waveoffood.databinding.FragmentHistoryfragmentBinding
import com.example.waveoffood.databinding.NotificationBottomFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList


class Notification_bottom_fragment : BottomSheetDialogFragment() {

    private lateinit var binding: NotificationBottomFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= NotificationBottomFragmentBinding.inflate(layoutInflater,container,false)
        val notifications= listOf("Find Someone Who Cares For You As We Care For You","Order Has Been Picked Up By Driver..\n How It Feels!!...Order Now","Feel Free To Order Ice Cream From\n Bhabhi's Phone If That Will Help")
        val notificationImages= listOf(R.drawable.care,R.drawable.truck,R.drawable.flirt)
        val adapter=NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationImages)
            )

        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter= adapter
        return binding.root
    }

    companion object {

    }
}