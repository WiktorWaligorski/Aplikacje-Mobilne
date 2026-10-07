package com.example.kosci2026;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.Random;

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
        ImageView[] obrazy = {
                findViewById(R.id.obrazek1),
                findViewById(R.id.obrazek2),
                findViewById(R.id.obrazek3),
                findViewById(R.id.obrazek4),
                findViewById(R.id.obrazek5)
        };
        int[] koscDrawables = {
                R.drawable.kosc1,
                R.drawable.kosc2,
                R.drawable.kosc3,
                R.drawable.kosc4,
                R.drawable.kosc5,
                R.drawable.kosc6
        };
        int[] values = {0, 0, 0, 0, 0};
        TextView result = findViewById(R.id.resultText);
        Random random = new Random();
        Button throwBtn = findViewById(R.id.throwBtn);
        throwBtn.setOnClickListener(v -> {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (obrazy[i].getAlpha() == 1.0){
                    values[i] = random.nextInt(6) + 1;
                    obrazy[i].setImageResource(koscDrawables[values[i] - 1]);
                }
                count += values[i];
            }
            result.setText(String.valueOf(count));
        });

    }

    public void changeDiceAvailability(View dice){
        if (dice.getAlpha() == 1.0){
            dice.setAlpha(0.5f);
        }
        else{
            dice.setAlpha(1.0f);
        }
    }
}