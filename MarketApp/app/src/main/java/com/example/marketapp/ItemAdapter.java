package com.example.marketapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Item> items;
    private ItemClickListener clickListener;

    public ItemAdapter(List<Item> items) {
        this.items = items;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = items.get(position);

        holder.imgImage.setImageResource(item.getImage());
        holder.txtName.setText(item.getName());
        holder.txtDesc.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imgImage;
        TextView txtName, txtDesc;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgImage = itemView.findViewById(R.id.itemImage);
            txtName = itemView.findViewById(R.id.itemName);
            txtDesc = itemView.findViewById(R.id.itemDesc);

            itemView.setOnClickListener(v -> {
                if (clickListener != null) {
                    clickListener.onClick(v, getBindingAdapterPosition());
                }
            });
        }
    }
}
