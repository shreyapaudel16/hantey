package com.example.hantey

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.example.hantey.Fragment.HomeFragment
import com.example.hantey.databinding.ActivityLoginBinding
import com.example.hantey.databinding.ActivitySignBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.ActionCodeEmailInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class SignActivity : AppCompatActivity() {
    private lateinit var email:String
    private lateinit var password:String
    private lateinit var username:String
    private lateinit var auth: FirebaseAuth
    private lateinit var database:DatabaseReference
    private val binding: ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //initialize firebase auth
        auth=Firebase.auth
        // initialize firebase database
        database= Firebase.database.reference

        binding.createAccountButton.setOnClickListener {
            username=binding.Username.text.toString()
            email=binding.EmailAddress.text.toString().trim()
            password=binding.Password.text.toString().trim()

            if(email.isEmpty()||password.isBlank()||username.isBlank()){
               Toast.makeText(this,"Please fill all details!",Toast.LENGTH_SHORT).show()
            }
            else{
                createAccount(email,password)
            }
        }


    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
            task ->
            if (task.isSuccessful){

            }

        }
    }


}

