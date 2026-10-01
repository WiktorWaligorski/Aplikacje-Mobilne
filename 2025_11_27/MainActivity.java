package com.example.zadanie;

import android.os.Bundle;
import android.view.View;
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
        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText txtname = findViewById(R.id.editTextText2);
                String name =  txtname.getText().toString();

                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void funkcja1(View view) {
        EditText txtname = findViewById(R.id.editTextText);
        String name =  txtname.getText().toString();

        final TextView text=findViewById(R.id.textView2);
        text.setText(name);
    }

}