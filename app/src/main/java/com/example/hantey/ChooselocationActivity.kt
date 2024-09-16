package com.example.hantey

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hantey.databinding.ActivityChooselocationBinding

class ChooselocationActivity : AppCompatActivity() {
    private val  binding:ActivityChooselocationBinding by lazy{
        ActivityChooselocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val locationList= arrayOf("Kathmandu","Lalitpur","Bhaktapur","Anamnagar","Kaski","chitwan","Butwal","Pokhara","Dharan")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView=binding.ListOfLocation
        autoCompleteTextView.setAdapter(adapter)
        binding.nextbutton.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}