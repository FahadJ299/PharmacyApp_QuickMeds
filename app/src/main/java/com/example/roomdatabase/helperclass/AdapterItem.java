package com.example.roomdatabase.helperclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.R;

import java.util.ArrayList;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.PhoneViewHolder> {

    private ArrayList<ItemHelper> phoneLocations;
    private ListItemClickListener listItemClickListener;
    private CheckboxClickListener checkboxClickListener;

    public AdapterItem(ArrayList<ItemHelper> phoneLocations, ListItemClickListener listItemClickListener, CheckboxClickListener checkboxClickListener) {
        this.phoneLocations = phoneLocations;
        this.listItemClickListener = listItemClickListener;
        this.checkboxClickListener = checkboxClickListener;
    }

    public ItemHelper getItem(int position) {
        return phoneLocations.get(position);
    }

    public interface ListItemClickListener {
        void onPhoneListClick(int clickedItemIndex);
    }

    public interface CheckboxClickListener {
        void onCheckboxClick(int position, boolean isChecked);
    }

    public class PhoneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView image;
        public TextView title;
        public RelativeLayout relativeLayout;
        public CheckBox cbHeart;

        public PhoneViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.text_title);
            relativeLayout = itemView.findViewById(R.id.background_color);
            cbHeart = itemView.findViewById(R.id.cbHeart);

            itemView.setOnClickListener(this);

            cbHeart.setOnCheckedChangeListener((buttonView, isChecked) -> checkboxClickListener.onCheckboxClick(getAdapterPosition(), isChecked));
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            listItemClickListener.onPhoneListClick(clickedPosition);
        }
    }

    @Override
    public PhoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pharmacy_list, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhoneViewHolder holder, int position) {
        ItemHelper itemHelper = phoneLocations.get(position);
        holder.image.setImageResource(itemHelper.getImage());
        holder.title.setText(itemHelper.getTitle());
        holder.relativeLayout.setBackgroundColor(itemHelper.getColor());
    }

    @Override
    public int getItemCount() {
        return phoneLocations.size();
    }
}
