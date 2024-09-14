package com.example.hantey


import adapter.MenuAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hantey.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuBottomSheetBinding.inflate(inflater,container,false)
        binding.buttonback.setOnClickListener {
            dismiss()
        }
        val menufoodname = listOf("Burger","Sandwich","momo","item","Breakfast","Cappuchino","Pasta")
        val menuitemprice = listOf("Rs250","Rs200","Rs290","Rs 310","Rs250","Rs200","Rs290")
        val menuimage= listOf(
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.momo1,
            R.drawable.combo,
            R.drawable.breakfast,
            R.drawable.cappuchino,
            R.drawable.pasta
        )
        val adapter = MenuAdapter(ArrayList(menufoodname),ArrayList(menuitemprice),ArrayList(menuimage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {


    }
}