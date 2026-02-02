package com.example.a02_02_2026;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Form extends Fragment {

    public Form() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        Button btn = view.findViewById(R.id.btnsend);
        EditText text = view.findViewById(R.id.mail);
        String mail = text.getText().toString();
         text = view.findViewById(R.id.imie);
        String imie = text.getText().toString();
        text = view.findViewById(R.id.nazwisko);
        String nazwisko = text.getText().toString();
        btn.setOnClickListener(v ->{
            if (mail != null && imie != null && nazwisko != null){
                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new display())
                        .commit();
            }
        });

        return view;
    }
}