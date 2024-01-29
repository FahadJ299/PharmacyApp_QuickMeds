package com.example.roomdatabase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedpreferences = getSharedPreferences("shared prefs", Context.MODE_PRIVATE);

        // Retrieve the username from the intent
        String username = getIntent().getStringExtra("username");

        // Display a welcome message
        if (username != null) {
            Toast.makeText(getApplicationContext(), "Welcome " + username, Toast.LENGTH_SHORT).show();
        }

        // Set the username in a TextView if needed
        TextView tName = findViewById(R.id.name);
        tName.setText(username != null ? username : "");

        CardView exit = findViewById(R.id.cardExit);

        exit.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.apply();

            startActivity(new Intent(HomeActivity.this, Login.class));
        });

        Button btnOpenProductsActivity = findViewById(R.id.btnOpenProductsActivity);

        btnOpenProductsActivity.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, ProductsActivity.class));
        });

        Button btnOpenFavActivity = findViewById(R.id.btnOpenFavActivity);

        btnOpenFavActivity.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, FavActivity.class));
        });
    }
}
