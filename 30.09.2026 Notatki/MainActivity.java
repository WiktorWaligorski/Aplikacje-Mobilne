package com.example.notatki;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
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


        Button addBtn = findViewById(R.id.add);
        EditText input = findViewById(R.id.input);

        ListView list = findViewById(R.id.NoteList);
        ArrayList<String> notes = new ArrayList<>();
        notes.add("Zakupy: chleb, masło, ser");
        notes.add("Do zrobienia: obiad, umyć podłogi");
        notes.add("weekend: kino, spacer z psem");

        ArrayAdapter<String> arrNotes;
        arrNotes = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, notes);
        list.setAdapter(arrNotes);

        addBtn.setOnClickListener(v -> {
            String newNote = input.getText().toString();
            notes.add(newNote);
            list.setAdapter(arrNotes);
        });
    }
}