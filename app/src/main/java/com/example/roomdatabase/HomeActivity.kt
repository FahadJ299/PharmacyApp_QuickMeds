package com.example.roomdatabase

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sharedpreferences = getSharedPreferences("shared prefs", Context.MODE_PRIVATE)

        // Retrieve the username from the intent
        val username = intent.getStringExtra("username")

        // Display a welcome message
        if (username != null) {
            Toast.makeText(applicationContext, "Welcome $username", Toast.LENGTH_SHORT).show()
        }

        // Set the username in a TextView if needed
        val tName: TextView = findViewById(R.id.name)
        tName.text = username ?: ""

        val exit: CardView = findViewById(R.id.cardExit)

        exit.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedpreferences.edit()
            editor.clear()
            editor.apply()

            startActivity(Intent(this@HomeActivity, Login::class.java))
        }

        val btnOpenProductsActivity: Button = findViewById(R.id.btnOpenProductsActivity)

        btnOpenProductsActivity.setOnClickListener {
            startActivity(Intent(this@HomeActivity, ProductsActivity::class.java))
        }

        val btnOpenFavActivity: Button = findViewById(R.id.btnOpenFavActivity)

        btnOpenFavActivity.setOnClickListener {
            startActivity(Intent(this@HomeActivity, FavActivity::class.java))
        }
    }
}
