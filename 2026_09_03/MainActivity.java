package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    public int dice_Throw(ImageView[] images, Drawable[] drawables){
        Random random = new Random();
        int Rolls[] = new int[5];
        for (int i = 0; i < 5; i++){
            Rolls[i] = random.nextInt(6) + 1;
            images[i].setImageDrawable(drawables[Rolls[i] - 1]);
        }
        return calculate_Score(Rolls);
    }

    public int calculate_Score(int[] Rolls){
        Map<Integer, Integer> count = new HashMap<>();
        for (int roll : Rolls){
            count.put(roll, count.getOrDefault(roll, 0) + 1);
        }
        int score = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (frequency >=2){
                score += number * frequency;
            }
        }

        return score;
    }

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

        ImageView d1 = findViewById(R.id.dice_1);
        ImageView d2 = findViewById(R.id.dice_2);
        ImageView d3 = findViewById(R.id.dice_3);
        ImageView d4 = findViewById(R.id.dice_4);
        ImageView d5 = findViewById(R.id.dice_5);

        ImageView[] images = {d1, d2, d3, d4, d5};
        Drawable[] diceDrawables = {
                getDrawable(R.drawable.k1),
                getDrawable(R.drawable.k2),
                getDrawable(R.drawable.k3),
                getDrawable(R.drawable.k4),
                getDrawable(R.drawable.k5),
                getDrawable(R.drawable.k6),
                getDrawable(R.drawable.question)};

        Button ThrowButton = findViewById(R.id.throw_but);
        Button Reset = findViewById(R.id.reset_button);

        TextView wynik = findViewById(R.id.score_cur);
        TextView total = findViewById(R.id.total_score);

        AtomicInteger score = new AtomicInteger();

        ThrowButton.setOnClickListener(v -> {
            int current_roll = dice_Throw(images, diceDrawables);
            wynik.setText("Wynik tego losowania: " + current_roll);
            score.set(score.get() + current_roll);
            total.setText("Wynik gry: " + score);
        });

        Reset.setOnClickListener(v -> {
            score.set(0);
            wynik.setText("Wynik tego losowania: " + 0);
            total.setText("Wynik gry: " + score);
            for(ImageView image : images){
                image.setImageDrawable(diceDrawables[6]);
            }
        });

    }
}