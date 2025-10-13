package com.example.volumearea;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        GridView grid = findViewById(R.id.gridView);

        GridModel[] items = {
                new GridModel(R.drawable.cylinder, "Cylinder"),
                new GridModel(R.drawable.cube, "Cube"),
                new GridModel(R.drawable.sphere, "Sphere"),
                new GridModel(R.drawable.prism, "Prism"),
        };

        var adapter = new GridAdapter(this, items);

        grid.setAdapter(adapter);
        grid.setOnItemClickListener((adapterView, view, i, id) -> {
            Intent intent = new Intent(this, CalculateActivity.class);

            if (i == 0) {
                intent.putExtra("type", IntentType.CYLINDER.name());
                intent.putExtra("label", "Calculate Cylinder");
                intent.putExtra("hint", "Enter Radius of Cylinder");
            } else if (i == 1) {
                intent.putExtra("type", IntentType.CUBE.name());
                intent.putExtra("label", "Calculate Cube");
                intent.putExtra("hint", "Enter Radius of Cube");
            } else if (i == 2) {
                intent.putExtra("type", IntentType.SPHERE.name());
                intent.putExtra("label", "Calculate Sphere");
                intent.putExtra("hint", "Enter Radius of Sphere");
            } else {
                intent.putExtra("type", IntentType.PRISM.name());
                intent.putExtra("label", "Calculate Prism");
                intent.putExtra("hint", "Enter b of Prism");
                intent.putExtra("hint2", "Enter h of Prism");
            }

            startActivity(intent);
        });
    }
}