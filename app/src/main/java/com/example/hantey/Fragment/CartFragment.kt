package com.example.hantey.Fragment

import adapter.CartAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hantey.CongratsBottomSheetFragment
import com.example.hantey.PayOutaActivity


import com.example.hantey.R
import com.example.hantey.databinding.FragmentCartBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class CartFragment : Fragment() {
    private lateinit var binding :FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)
        val cartfoodname = listOf("Burger","Sandwich","momo","item")
        val cartitemprice = listOf("Rs250","Rs200","Rs290","Rs 310")
        val cartimage= listOf(
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.momo1,
            R.drawable.combo
        )
        val adapter = CartAdapter(ArrayList(cartfoodname),ArrayList(cartitemprice),ArrayList(cartimage))
        binding.cartRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerview.adapter = adapter
        binding.proceedbutton.setOnClickListener{
            val intent = Intent(requireContext(),PayOutaActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

        companion object {

            }
    }
