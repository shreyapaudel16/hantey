package com.example.hantey.Fragment

import com.example.hantey.adapter.Popularadapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hantey.MenuBottomSheetFragment

import com.example.hantey.R
import com.example.hantey.databinding.FragmentHomeBinding


 class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
         binding.viewAllMenu.setOnClickListener {
             val bottomSheetDialog = MenuBottomSheetFragment()
             bottomSheetDialog.show(parentFragmentManager,"Test")
         }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val foodname = listOf("Salad", "Burger","momo","Item")
        val price = listOf("Rs 250", "Rs 200","Rs 190","Rs 350")
        val popularfoodimages =listOf(R.drawable.breakfast,R.drawable.burger,R.drawable.chicken,R.drawable.combo)
        val adapter = Popularadapter(foodname, price, popularfoodimages,requireContext())
        binding.popularrecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.popularrecyclerview.adapter = adapter
    }

    companion object {

    }
}