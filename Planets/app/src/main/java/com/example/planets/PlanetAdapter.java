package com.example.planets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PlanetAdapter extends ArrayAdapter<Planet> {
    private Context context;
    private ArrayList<Planet> items;

    public PlanetAdapter(Context context, ArrayList<Planet> items) {
        super(context, R.layout.plate_list_view, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int i, View view, @NonNull ViewGroup viewGroup) {
        Planet planet = getItem(i);
        ViewHolder holder;
        final View result;

        if (view == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.plate_list_view,
                    viewGroup, false);


            holder.image = view.findViewById(R.id.image);
            holder.label = view.findViewById(R.id.label);
            holder.desc = view.findViewById(R.id.desc);

            result = view;
            view.setTag(holder);
            System.out.println("View is Null");
        } else {
            holder = (ViewHolder) view.getTag();
            result = view;
            System.out.println("View is not Null");
        }

        assert planet != null;
        holder.image.setImageResource(planet.getSrc());
        holder.label.setText(planet.getLabel());
        holder.desc.setText(planet.getDesc());

        return result;
    }

    static class ViewHolder {
        ImageView image;
        TextView label;
        TextView desc;

    }
}
