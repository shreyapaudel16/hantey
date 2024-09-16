package com.example.hantey

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hantey.databinding.ActivityLoginBinding
import com.example.hantey.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class LoginActivity : AppCompatActivity() {
    private  var username : String?=null
    private lateinit var email:String
    private lateinit var password:String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        //Initialization of Firebase Auth
        auth=Firebase.auth
        //Initialization of Firebase database
        database= Firebase.database.reference

        //login with email and password
        binding.loginbutton.setOnClickListener{
            //get data from text field
            email=binding.emailAddress.text.toString().trim()
            password=binding.password.text.toString().trim()
            if (email.isBlank()||password.isBlank()){
                Toast.makeText(this,"Please enter the details",Toast.LENGTH_SHORT).show()
            }
            else{
                createuser()
                Toast.makeText(this,"Login Successfull",Toast.LENGTH_SHORT).show()
              }
            val intent=Intent(this,ChooselocationActivity::class.java)
            startActivity(intent)
        }


        binding.donthavebutton.setOnClickListener {
            val intent=Intent(this,SignActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createuser() {
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            task->
            if(task.isSuccessful){
                val user =auth.currentUser
                updateUi(user)
            }
            else
            {
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task->
                    if(task.isSuccessful){
                        saveUserdata()
                        val user=auth.currentUser
                        updateUi(user)
                    }
                    else
                    {
                        Toast.makeText(this,"Sign in Failed",Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }
    }

    private fun saveUserdata() {
        //get data from text field
        email=binding.emailAddress.text.toString().trim()
        password=binding.password.text.toString().trim()
        val user=UserModel(username,email,password)
        val userId=FirebaseAuth.getInstance().currentUser!!.uid
        //save data in database
        database.child("user").child(userId).setValue(user)
    }

    private fun updateUi(user: FirebaseUser?) {
        val intent=Intent(this,ChooselocationActivity::class.java)
        startActivity(intent)
        finish()
    }
}







