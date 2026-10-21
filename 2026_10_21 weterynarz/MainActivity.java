package com.example.weterynarz;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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

        ArrayList<String> animals = new ArrayList<>();
        animals.add("Pies");
        animals.add("Kot");
        animals.add("Świnka morska");

        ListView animalList = findViewById(R.id.animal_list);
        SeekBar slider = findViewById(R.id.slider);
        TextView age = findViewById(R.id.age);
        Button send = findViewById(R.id.toastBtn);
        EditText ownerInput = findViewById(R.id.owner);
        EditText cause = findViewById(R.id.cause);
        EditText time = findViewById(R.id.time);

        int[] pos = new int[1];
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                animals
        );

        animalList.setAdapter(adapter);

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        animalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = animalList.getItemAtPosition(position);

                switch (listItem.toString()) {
                    case "Pies":
                        slider.setMax(18);
                        pos[0] = 0;
                        break;
                    case "Kot":
                        slider.setMax(20);
                        pos[0] = 1;
                        break;
                    case "Świnka morska":
                        slider.setMax(9);
                        pos[0] = 2;
                        break;
                }

            }
        });

        send.setOnClickListener(v -> {
            Toast.makeText(this, ownerInput.getText().toString() + ", \n" +
                    animalList.getItemAtPosition(pos[0]) + ", \n" +
                    age.getText() + ", \n" +
                    cause.getText() + ", \n" +
                    time.getText(), Toast.LENGTH_LONG).show();
        });
    }}