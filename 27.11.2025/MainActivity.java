package com.example.a27112025;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(press);
    }

    public void displayText(View view){

        final EditText text=findViewById(R.id.Input1);
        String output = text.getText().toString();
        final TextView field=findViewById(R.id.textView);
        field.setText(output);
    }

    private View.OnClickListener press = new View.OnClickListener(){
        public void onClick(View view){
            final EditText text=findViewById(R.id.Input2);
            String output = text.getText().toString();

            Toast.makeText(getApplicationContext(), output, Toast.LENGTH_SHORT).show();

        }
    };
}