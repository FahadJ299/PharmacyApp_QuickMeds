package com.example.roomdatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.helperclass.AdapterItem
import com.example.roomdatabase.helperclass.ItemHelper
import java.util.ArrayList

class
ProductsActivity : AppCompatActivity(), AdapterItem.ListItemClickListener, AdapterItem.CheckboxClickListener {

    private lateinit var adapterItem: AdapterItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val recycler: RecyclerView = findViewById(R.id.pharmacy_list)
        recycler.layoutManager = LinearLayoutManager(this)

        val phonelocations = ArrayList<ItemHelper>().apply {
            add(ItemHelper(R.color.card5, R.drawable.shampoo, "Rs: 999"))
            add(ItemHelper(R.color.card7, R.drawable.moisturizer, "Rs: 825"))
            add(ItemHelper(R.color.card4, R.drawable.panadol, "Rs: 645"))
            add(ItemHelper(R.color.card3, R.drawable.coughsyrup, "Rs: 765"))
        }
        adapterItem = AdapterItem(phonelocations, this, this)

        recycler.adapter = adapterItem
    }
    override fun onPhoneListClick(clickedItemIndex: Int) {
        // Handle item click if needed
    }
    override fun onCheckboxClick(position: Int, isChecked: Boolean) {
        if (isChecked) {
            // Handle checkbox click, e.g., add item to favorites
            // Implement the logic to add the item to favorites
        } else {
            // Handle unchecked state if needed
        }
    }
}
