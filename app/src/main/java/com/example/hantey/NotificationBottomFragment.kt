package com.example.hantey

import adapter.NotificationAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hantey.databinding.FragmentNotificationbottomfragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList


class NotificationBottomFragment : BottomSheetDialogFragment() {
 private lateinit var binding: FragmentNotificationbottomfragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentNotificationbottomfragmentBinding.inflate(layoutInflater,container,false)
        val notifications= listOf("Your order has been cancelled","Driver has picked up your order","Your order has been placed")
        val notificationImage = listOf(R.drawable.cancel,R.drawable.pickup,R.drawable.orderplaced)
        val adapter= NotificationAdapter(
           ArrayList(notifications),
            ArrayList(notificationImage)
        )
        return binding.root
    }

    companion object {

    }
}