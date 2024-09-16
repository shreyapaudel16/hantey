package com.example.hantey.Fragment

import com.example.hantey.adapter.MenuAdapter
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hantey.R
import com.example.hantey.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
  private lateinit var binding:FragmentSearchBinding
  private lateinit var adapter: MenuAdapter
  private val originalMenuFoodName = listOf("Burger","Sandwich","momo","item","Breakfast","Cappuchino","Pasta")
    private val originalMenuItemPrice = listOf("Rs250","Rs200","Rs290","Rs 310","Rs250","Rs200","Rs290")
    private val originalMenuImage= listOf(
        R.drawable.burger,
        R.drawable.sandwich,
        R.drawable.momo1,
        R.drawable.combo,
        R.drawable.breakfast,
        R.drawable.cappuchino,
        R.drawable.pasta
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
     private val filteredMenuFoodName= mutableListOf<String>()
     private val filteredItemPrice= mutableListOf<String>()
     private val filteredMenuImage= mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredMenuFoodName,filteredItemPrice,filteredMenuImage,requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        //setup for search view
        setupSearchView()
        //show all menu items
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
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
        filteredItemPrice.clear()
        filteredMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, FoodName ->
            if(FoodName.contains(query.toString(),ignoreCase = true)){
                filteredMenuFoodName.add(FoodName)
                filteredItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }


    companion object {

    }
}