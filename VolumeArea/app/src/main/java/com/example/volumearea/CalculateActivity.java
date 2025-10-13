package com.example.volumearea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculateActivity extends AppCompatActivity {
    private TextView label, result;
    private EditText input, input2;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        label = findViewById(R.id.label);
        result = findViewById(R.id.result);
        input = findViewById(R.id.input);
        calculate = findViewById(R.id.calculate);
        input2 = findViewById(R.id.input2);

        Intent intent = getIntent();

        label.setText(intent.getStringExtra("label"));
        input.setHint(intent.getStringExtra("hint"));

        IntentType type = IntentType.valueOf(intent.getStringExtra("type"));
        Toast.makeText(this,
                type.toString(), Toast.LENGTH_SHORT).show();

        if (type.equals(IntentType.PRISM)) {
            input2.setVisibility(View.VISIBLE);
            input2.setHint(intent.getStringExtra("hint2"));
        }

        calculate.setOnClickListener(v -> {
            int val = Integer.parseInt(input.getText().toString());
            String calculatedResult;

            if (type.equals(IntentType.CYLINDER)) {
                calculatedResult = "Result: " + getCylinder(val);
            } else if (type.equals(IntentType.CUBE)) {
                calculatedResult = "Result: " + getCube(val);
            } else if (type.equals(IntentType.SPHERE)) {
                calculatedResult = "Result: " + getSphere(val);
            } else {
                int h = Integer.parseInt(input2.getText().toString());
                calculatedResult = "Result: " + getPrism(val, h);
            }

            result.setText(calculatedResult);
        });
    }

    private double getCylinder(int r) {
        return ((double) 4 / 3) * Math.PI * Math.pow(r, 3);
    }

    private double getCube(int a) {
        return 6 * Math.pow(a, 2);
    }

    private double getSphere(int r) {
        return 4 * Math.PI * Math.pow(r, 2);
    }

    private double getPrism(int b, int h) {
        return b * h;
    }
}