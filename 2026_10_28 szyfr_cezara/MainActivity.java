package com.example.szyfrowanie_desktop_remake;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        EditText input = findViewById(R.id.TextInput);
        TextView output = findViewById(R.id.TextOutput);
        Button encodeBtn = findViewById(R.id.encodeBtn);

        TextView keyInput = findViewById(R.id.keyInput);

        encodeBtn.setOnClickListener(v -> {
            int key;
            if (keyInput.getText().toString().isEmpty()){
                key = 0;
            }
            else {
                try {
                    key = Integer.parseInt(keyInput.getText().toString());
                }
                catch (NumberFormatException e){
                    key = 0;
                }
            }
            String encodedText = "";
            String rawText = input.getText().toString();
            char[] rawTxtArr = rawText.toCharArray();

            for (int i = 0; i < rawText.length(); i++){
                if (rawTxtArr[i] == ' '){
                    encodedText += rawTxtArr[i];
                    continue;
                }
                int newChar = rawTxtArr[i] + key;
                while (newChar < 97 || newChar > 122){
                    if (newChar < 97) {
                        newChar = 122 - (96 - newChar);
                    } else if (newChar > 122) {
                        newChar = 97 + (newChar - 123);
                    }
                }
                encodedText += (char)newChar;
                Toast.makeText(getApplicationContext(), " " + newChar, Toast.LENGTH_SHORT).show();
            }
            output.setText(encodedText);
        });



    }
}