package com.example.roomdatabase.helperclass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import java.util.ArrayList

class AdapterItem(
    private val phoneLocations: ArrayList<ItemHelper>,
    private val listItemClickListener: ListItemClickListener,
    private val checkboxClickListener: CheckboxClickListener
) : RecyclerView.Adapter<AdapterItem.PhoneViewHolder>() {

    interface ListItemClickListener {
        fun onPhoneListClick(clickedItemIndex: Int)
    }

    interface CheckboxClickListener {
        fun onCheckboxClick(position: Int, isChecked: Boolean)
    }

    inner class PhoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var image: ImageView = itemView.findViewById(R.id.imageView)
        var title: TextView = itemView.findViewById(R.id.text_title)
        var relativeLayout: RelativeLayout = itemView.findViewById(R.id.background_color)
        var cbHeart: CheckBox = itemView.findViewById(R.id.cbHeart)

        init {
            itemView.setOnClickListener(this)

            cbHeart.setOnCheckedChangeListener { buttonView, isChecked ->
                checkboxClickListener.onCheckboxClick(adapterPosition, isChecked)
            }
        }

        override fun onClick(v: View) {
            val clickedPosition = adapterPosition
            listItemClickListener.onPhoneListClick(clickedPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_pharmacy_list, parent, false)
        return PhoneViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val itemHelper = phoneLocations[position]
        holder.image.setImageResource(itemHelper.image)
        holder.title.text = itemHelper.title
        holder.relativeLayout.setBackgroundColor(itemHelper.color)
    }
    override fun getItemCount(): Int {
        return phoneLocations.size
    }
}
