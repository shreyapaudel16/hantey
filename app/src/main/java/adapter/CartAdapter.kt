package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hantey.databinding.CartItemBinding

class CartAdapter(private val Cartitems:MutableList<String>,private val Cartitemprice:MutableList<String>,private var Cartimage:MutableList<Int>): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemquantities = IntArray(Cartitems.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = Cartitems.size

    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemquantities[position]
                cartfoodname.text = Cartitems[position]
                cartitemprice.text = Cartitemprice[position]
                cartimage.setImageResource(Cartimage[position])
                cartitemquantity.text = quantity.toString()

                minusbutton.setOnClickListener{
                    decreaseQuantity(position)
                }
                plusbutton.setOnClickListener {
                    increaseQuantity(position)
                }
                deletebutton.setOnClickListener {
                    val itemPosition =adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION){
                        deleteItem(itemPosition)

                    }
                }
                }
        }
        private fun increaseQuantity(position: Int){
            if (itemquantities[position]<10) {
                itemquantities[position]++
                binding.cartitemquantity.text = itemquantities[position].toString()
            }

            }
        private fun decreaseQuantity(position: Int){
            if (itemquantities[position]>1){
                itemquantities[position]--
                binding.cartitemquantity.text=itemquantities[position].toString()
            }

        }
        private fun deleteItem(position: Int){
            Cartitems.removeAt(position)
            Cartimage.removeAt(position)
            Cartitemprice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,Cartitems.size)
        }
    }
}
