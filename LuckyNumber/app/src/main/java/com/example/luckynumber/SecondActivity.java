package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView label, txtNumber;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        label = findViewById(R.id.label);
        txtNumber = findViewById(R.id.txtNumber);
        button = findViewById(R.id.button2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int num = intent.getIntExtra("number", 0);

        label.setText(name + " Your Lucky Number is");
        txtNumber.setText(String.valueOf(num));

        button.setOnClickListener(v -> {
            Intent intent1 = new Intent(Intent.ACTION_SEND);
            intent1.setType("text/plain");

            intent1.putExtra(Intent.EXTRA_SUBJECT, name + " got lucky today");
            intent1.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + num);

            startActivity(Intent.createChooser(intent1, "Choose An App to send"));
        });
    }
}