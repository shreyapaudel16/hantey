package com.example.hantey.adapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hantey.DetailsActivity
import com.example.hantey.databinding.FragmentHomeBinding
import com.example.hantey.databinding.PopularItemBinding

class Popularadapter(private val items:List<String>,private val price:List<String>, private val image:List<Int>,private val requireContext:Context) : RecyclerView.Adapter<Popularadapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)

        holder.itemView.setOnClickListener{
            val intent= Intent(requireContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName",item)
            intent.putExtra("MenuItemImage",images)
            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return items.size

    }
    class PopularViewHolder (private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root){
      private val imagesview=binding.imageView2
        fun bind(item: String,price:String, images: Int) {
            binding.menufoodname.text = item
            binding.pricepopular.text =price
            imagesview.setImageResource(images)
        }

    }
}