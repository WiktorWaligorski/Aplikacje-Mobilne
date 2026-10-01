package com.example.urzadzenia_domowe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;

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

        Button UstawNumerPrania = findViewById(R.id.NumerPraniaSet);
        TextView PokazNumerPrania = findViewById(R.id.NumerPraniaDisplay);

        UstawNumerPrania.setOnClickListener(v -> {
            EditText NumerPrania = findViewById(R.id.NumerPraniaInput);
            int Numer = Integer.parseInt(NumerPrania.getText().toString());
            if (Numer > 0 && Numer < 13){
                PokazNumerPrania.setText("Numer prania: " + Numer);
            }

        });

        Button PrzelaczOdkurzacz = findViewById(R.id.OdkurzaczBtn);
        TextView Status = findViewById(R.id.StatusOdkurzacza);
        PrzelaczOdkurzacz.setOnClickListener(v -> {
            if (PrzelaczOdkurzacz.getText().toString().equals("Włącz")){
                Status.setText("odkurzacz włączony");
                PrzelaczOdkurzacz.setText("Wyłącz");
            } else if (PrzelaczOdkurzacz.getText().toString().equals("Wyłącz")) {
                Status.setText("odkurzacz wyłączony");
                PrzelaczOdkurzacz.setText("Włącz");
            }
        });
    }
}