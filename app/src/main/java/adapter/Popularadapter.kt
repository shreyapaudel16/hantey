package adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hantey.databinding.FragmentHomeBinding
import com.example.hantey.databinding.PopularItemBinding

class Popularadapter(private val items:List<String>,private val price:List<String>, private val image:List<Int>) : RecyclerView.Adapter<Popularadapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)

    }

    override fun getItemCount(): Int {
        return items.size

    }
    class PopularViewHolder (private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root){
      private val imagesview=binding.imageView11
        fun bind(item: String,price:String, images: Int) {
            binding.Foodnamepopular.text = item
            binding.Pricepopular.text =price
            imagesview.setImageResource(images)
        }

    }
}