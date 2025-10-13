package com.example.planets;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

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

        ListView listView = findViewById(R.id.listView);

        ArrayList<Planet> planets = new ArrayList<>(Arrays.asList(
                new Planet(R.drawable.mercury, "Mercury", "Mercury is the smallest planet."),
                new Planet(R.drawable.venus, "Venus", "Venus is the second planet."),
                new Planet(R.drawable.earth, "Earth", "Earth is the third planet."),
                new Planet(R.drawable.mars, "Mars", "Mars is the fourth planet."),
                new Planet(R.drawable.jupiter, "Jupiter", "Jupiter is the fifth planet."),
                new Planet(R.drawable.saturn, "Saturn", "Saturn is the sixth planet."),
                new Planet(R.drawable.uranus, "Uranus", "Uranus is the seventh planet."),
                new Planet(R.drawable.neptune, "Neptune", "Neptune is the eighth planet.")
        ));

        listView.setAdapter(new PlanetAdapter(this, planets));
    }
}