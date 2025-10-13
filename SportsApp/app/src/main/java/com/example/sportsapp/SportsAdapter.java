package com.example.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ItemViewHolder> {
    private List<Sport> sports;
    private SportsClickListener listener;


    public SportsAdapter(List<Sport> sports) {
        this.sports = sports;
    }

    public void setOnClickListener(SportsClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Sport sport = sports.get(position);

        holder.image.setImageResource(sport.getImageId());
        holder.label.setText(sport.getText());
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView label;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cardImage);
            label = itemView.findViewById(R.id.cardText);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onClick(v, getBindingAdapterPosition());
                }
            });
        }
    }
}
