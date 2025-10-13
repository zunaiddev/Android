package com.example.marketapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        items = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.fruit, "Fruits", "Fresh Fruits From the Garden"),
                new Item(R.drawable.bread, "Bread", "Fresh Bread From the Meal"),
                new Item(R.drawable.beverage, "Beverage", "Fresh beverage From the Garden"),
                new Item(R.drawable.milk, "Milk", "Pure Milk From the Diary"),
                new Item(R.drawable.popcorn, "Popcorn", "Best Fresh Popcorn"),
                new Item(R.drawable.vegitables, "Vegetables", "Fresh Vegetables From the Garden")
        ));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ItemAdapter adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);

        adapter.setClickListener((view, pos) -> {
            Toast.makeText(this,
                    items.get(pos).getName(),
                    Toast.LENGTH_SHORT).show();
        });
    }
}