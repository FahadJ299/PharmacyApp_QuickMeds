package com.example.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference= firebaseDatabase.reference.child("users")

        binding.signupButton.setOnClickListener{
            val signupUsername = binding.signupUsername.text.toString()
            val signupPassword = binding.signupPassword.text.toString()
            if (signupUsername.isNotEmpty()&& signupPassword.isNotEmpty()){
                mainUser(signupUsername, signupPassword)
            } else{
                Toast.makeText(this@MainActivity, "All fields are mandatory ", Toast.LENGTH_SHORT).show()
            }

        }
        binding.loginRedirect.setOnClickListener {
            startActivity(Intent(this@MainActivity, Login::class.java))
            finish()
        }


    }
    private fun mainUser(username: String, password: String){
        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (!dataSnapshot.exists()){
                    val id = databaseReference.push().key
                    val userData = UserData(id, username,password)
                    databaseReference.child(id!!).setValue(userData)
                    Toast.makeText(this@MainActivity, "Signup Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MainActivity, Login::class.java))
                    finish()
                } else{
                    Toast.makeText(this@MainActivity, "User already exists ", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@MainActivity, "Database Error: ${databaseError.message}", Toast.LENGTH_SHORT).show()

            }
        })
    }

}
