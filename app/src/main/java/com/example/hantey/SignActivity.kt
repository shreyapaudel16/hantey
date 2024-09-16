package com.example.hantey

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.example.hantey.Fragment.HomeFragment
import com.example.hantey.databinding.ActivityLoginBinding
import com.example.hantey.databinding.ActivitySignBinding
import com.example.hantey.model.UserModel
import com.google.android.gms.common.api.Api.Client
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

        binding.alreadyhavebutton.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }





    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                task ->
            if (task.isSuccessful){
                Toast.makeText(this,"Account Created sucessfully",Toast.LENGTH_SHORT).show()
                saveUserData()
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }else{
                Toast.makeText(this,"Account Created Failed",Toast.LENGTH_SHORT).show()
                Log.d("Account", "createAccount: Failure ",task.exception)
            }

        }
    }
    //save data into database
    private fun saveUserData(){
        //retrieve data from input filed
        username=binding.Username.text.toString()
        email=binding.EmailAddress.text.toString().trim()
        password=binding.Password.text.toString().trim()
        val user=UserModel(username,email,password)
        val userId=FirebaseAuth.getInstance().currentUser!!.uid
        //save data to Firebase database
        database.child("user").child(userId).setValue(user)
    }

}