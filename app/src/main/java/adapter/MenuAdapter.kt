package adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hantey.DetailsActivity
import com.example.hantey.databinding.MenuItemBinding

class MenuAdapter(
    private val menuItemsName: List<String>,
    private val menuItemPrice: List<String>,
    private val menuImage: List<Int>,private val requireContext:Context ) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
private val itemCLickListener: OnClickListener ?=null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
      val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int=menuItemsName.size
    inner class MenuViewHolder(private val binding : MenuItemBinding ):RecyclerView.ViewHolder(binding.root) {
       init {
           binding.root.setOnClickListener{
               val position=adapterPosition
               if(position != RecyclerView.NO_POSITION){
                   itemCLickListener?.OnItemClick(position)
               }

               //set on click listener to open details
               val intent= Intent(requireContext,DetailsActivity::class.java)
               intent.putExtra("MenuItemName",menuItemsName.get(position))
               intent.putExtra("MenuItemImage",menuImage.get(position))
               requireContext.startActivity(intent)
           }
       }
        fun bind(position: Int) {
            binding.apply {
                menufoodname.text=menuItemsName[position]
                menuprice.text=menuItemPrice[position]
                menuimage.setImageResource(menuImage[position])

            }

        }

    }

    interface OnClickListener {

        fun OnItemClick(position: Int)

    }
}


