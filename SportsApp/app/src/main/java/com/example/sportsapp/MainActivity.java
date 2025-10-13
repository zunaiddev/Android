package com.example.sportsapp;

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

        List<Sport> sports = new ArrayList<>(Arrays.asList(
                new Sport(R.drawable.basketball, "Basketball"),
                new Sport(R.drawable.football, "Football"),
                new Sport(R.drawable.ping, "Ping Pong"),
                new Sport(R.drawable.tennis, "Tennis"),
                new Sport(R.drawable.volley, "Volleyball")
        ));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        SportsAdapter adapter = new SportsAdapter(sports);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        adapter.setOnClickListener((v, pos) -> {
            Toast.makeText(this,
                    sports.get(pos).getText(),
                    Toast.LENGTH_SHORT).show();
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}