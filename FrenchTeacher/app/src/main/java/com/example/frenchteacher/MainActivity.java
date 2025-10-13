package com.example.frenchteacher;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRed, btnGreen, btnBlue, btnYellow, btnPurple;

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

        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnBlue = findViewById(R.id.btnBlue);
        btnYellow = findViewById(R.id.btnYellow);
        btnPurple = findViewById(R.id.btnPurple);

        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnPurple.setOnClickListener(this);
    }

    public void playSound(int id) {
        MediaPlayer player = MediaPlayer.create(this, id);
        player.start();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btnRed) playSound(R.raw.red);
        else if (id == R.id.btnGreen) playSound(R.raw.green);
        else if (id == R.id.btnBlue) playSound(R.raw.black);
        else if (id == R.id.btnYellow) playSound(R.raw.yellow);
        else if (id == R.id.btnPurple) playSound(R.raw.purple);
    }
}