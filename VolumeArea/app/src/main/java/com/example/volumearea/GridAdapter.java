package com.example.volumearea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private GridModel[] items;

    public GridAdapter(Context context, GridModel[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        GridModel model = items[i];

        if (view == null) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.grid_view, viewGroup, false);

            holder = new ViewHolder();

            holder.imageView = view.findViewById(R.id.imageView);
            holder.textView = view.findViewById(R.id.textView);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.imageView.setImageResource(model.getImage());
        holder.textView.setText(model.getText());

        return view;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}