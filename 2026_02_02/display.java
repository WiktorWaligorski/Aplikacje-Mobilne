package com.example.a02_02_2026;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class display extends Fragment {

    private String mail;
    private String imie;
    private String nazwisko;

    public display() {
        // wymagany przez Androida
    }

    public static display newInstance(String mail, String imie, String nazwisko) {

        Bundle args = new Bundle();

        display fragment = new display();
        args.putString("mail", mail);
        args.putString("imie", imie);
        args.putString("nazwisko", nazwisko);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mail = getArguments().getString("mail");
            imie = getArguments().getString("imie");
            nazwisko = getArguments().getString("nazwisko");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_display, container, false);

        TextView mailText = view.findViewById(R.id.mailDisplay);
        TextView nameText = view.findViewById(R.id.nameDisplay);
        TextView surnameText = view.findViewById(R.id.surnameDisplay);

        mailText.setText(mail);
        nameText.setText(imie);
        surnameText.setText(nazwisko);

        return view;
    }


}
