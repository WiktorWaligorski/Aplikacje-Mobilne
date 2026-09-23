package com.example.good_day;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicInteger;

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

        TextView size = findViewById(R.id.textSize);
        TextView quote = findViewById(R.id.cytat);
        SeekBar bar = findViewById(R.id.seekBar);

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                size.setText("Rozmiar: " + progress);
                quote.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        String[] Greetings = {"Dzień dobry", "Good morning", "Buenos dias"};
        AtomicInteger iterator = new AtomicInteger();
        Button but = findViewById(R.id.button);
        but.setOnClickListener(v -> {
            if (iterator.get() == 2){
                iterator.set(0);
            }
            else {
                iterator.addAndGet(1);
            }
            quote.setText(Greetings[iterator.get()]);
        });

    }
}