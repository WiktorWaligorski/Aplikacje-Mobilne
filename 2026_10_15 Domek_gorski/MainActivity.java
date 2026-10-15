package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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

        Button like = findViewById(R.id.polubBtn);
        Button dislike = findViewById(R.id.usunBtn);
        TextView counterText = findViewById(R.id.liczba_polubien);
        AtomicInteger count = new AtomicInteger(0);



        like.setOnClickListener(v -> {
            count.addAndGet(1);
            counterText.setText(count.get() + " polubień");
        });

        dislike.setOnClickListener(v -> {
            if (count.get() > 0){
                count.addAndGet(-1);
                counterText.setText(count.get() + " polubień");
            }

        });
    }
}