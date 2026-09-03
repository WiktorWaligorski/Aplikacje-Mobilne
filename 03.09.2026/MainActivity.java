package com.example.egzamin_mobilki_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Array;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int dice_Throw(){
        Random random = new Random();
        int Rolls[] = new int[5];

        for (int i = 0; i < 5; i++){
            Rolls[i] = random.nextInt(6) + 1;
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

        Button ThrowButton = findViewById(R.id.throw_but);
        TextView wynik = findViewById(R.id.score_cur);

        ThrowButton.setOnClickListener(v -> {
            int score = dice_Throw();
            wynik.setText("Wynik tego losowania: " + score);
        });

    }
}