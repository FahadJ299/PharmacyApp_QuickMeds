package com.example.roomdatabase;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.helperclass.ItemHelper;
import com.example.roomdatabase.helperclass.ItemHelper;
import com.example.roomdatabase.helperclass.AdapterItem;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity implements AdapterItem.ListItemClickListener, AdapterItem.CheckboxClickListener {

    private AdapterItem adapterItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        RecyclerView recycler = findViewById(R.id.pharmacy_list);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ItemHelper> phonelocations = new ArrayList<>();
        phonelocations.add(new ItemHelper(R.color.card5, R.drawable.shampoo, "Rs: 999"));
        phonelocations.add(new ItemHelper(R.color.card7, R.drawable.moisturizer, "Rs: 825"));
        phonelocations.add(new ItemHelper(R.color.card4, R.drawable.panadol, "Rs: 645"));
        phonelocations.add(new ItemHelper(R.color.card3, R.drawable.coughsyrup, "Rs: 765"));

        adapterItem = new AdapterItem(phonelocations, this, this);

        recycler.setAdapter(adapterItem);
    }

    @Override
    public void onPhoneListClick(int clickedItemIndex) {
        // Handle item click if needed
    }

    @Override
    public void onCheckboxClick(int position, boolean isChecked) {
        if (isChecked) {
            // Handle checkbox click, e.g., add item to favorites
            // Implement the logic to add the item to favorites
        } else {
            // Handle unchecked state if needed
        }
    }
}
