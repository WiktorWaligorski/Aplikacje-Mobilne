package com.example.myapplication;

import android.os.Bundle;

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
    }

    public void send(View view){
        TextView komunikat = findViewById(R.id.poleKomunikatu);
        EditText mail = findViewById(R.id.TextEmailAddress);
        String mailText = mail.getText().toString();
        if (checkMail() && checkPassword()){
            komunikat.setText("Witaj " + mailText);
        } else if (checkMail() && !checkPassword()) {
            komunikat.setText("Hasła się różnią");
        }
        else{
            komunikat.setText("Nieprawidłowy adres email");
        }
    }

    public Boolean checkMail(){
        EditText txt = findViewById(R.id.TextEmailAddress);
        String mail = txt.getText().toString();
        return (mail.contains("@"));
    }

    public Boolean checkPassword(){
        EditText pass1 = findViewById(R.id.TextPassword);
        EditText pass2 = findViewById(R.id.TextPassword2);
        String pass1S = pass1.getText().toString();
        String pass2S = pass2.getText().toString();

        return (pass1S.equals(pass2S));
    }

}