package com.example.week4fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentView,new FirstFragment())
                .commit();
    }
}