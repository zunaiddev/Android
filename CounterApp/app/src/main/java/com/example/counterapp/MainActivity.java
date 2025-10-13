package com.example.counterapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnIncrease, btnDecrease, btnReset;
    TextView txtCounter;
    int counter = 0;

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

        btnIncrease = findViewById(R.id.btnIncrease);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnReset = findViewById(R.id.btnReset);
        txtCounter = findViewById(R.id.counter);

        btnIncrease.setOnClickListener(v -> setCount(++counter));

        btnDecrease.setOnClickListener(v -> {
            counter--;

            if (counter < 0) {
                counter = 0;
                setCount(counter);
            } else {
                setCount(counter);
            }
        });

        btnReset.setOnClickListener(v -> {
            counter = 0;
            setCount(counter);
        });
    }

    private void setCount(int counter) {
        txtCounter.setText(String.valueOf(counter));
    }
}