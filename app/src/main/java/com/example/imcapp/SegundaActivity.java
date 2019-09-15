package com.example.imcapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class SegundaActivity extends AppCompatActivity {
    Context context;

    private TextView result;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);

        result = findViewById(R.id.textView);

        String value = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("resultado");
        }

        result.setText(value);
    }



}
