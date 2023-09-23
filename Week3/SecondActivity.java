package com.example.week3implementation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SecondActivity extends AppCompatActivity {

    TextView textViewGreeting;

    EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textViewGreeting = findViewById(R.id.textViewGreeting);


        /*
        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(MainActivity.NAME_KEY)){
            String greet = getIntent().getStringExtra(MainActivity.NAME_KEY);
            textViewGreeting.setText( "Hola 👋" + greet );
        } */
        /*
        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(MainActivity.USER_KEY)){
            User user = (User) getIntent().getSerializableExtra(MainActivity.USER_KEY);
            textViewGreeting.setText( "Hola 👋" + user.name + ". Your age is " + user.age );
        }
         */
        /*
        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(MainActivity.USERS_KEY)){
            ArrayList<User> users = (ArrayList<User>) getIntent().getSerializableExtra(MainActivity.USERS_KEY);
            Collections.shuffle(users);
            User user = users.get(0);
            textViewGreeting.setText( "Hola 👋" + user.name + ". Your age is " + user.age );
        }
         */
        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(MainActivity.PARCELABLE_USER_KEY)){
            User user = getIntent().getParcelableExtra(MainActivity.PARCELABLE_USER_KEY);
            textViewGreeting.setText( "Hola 👋" + user.name + ". Your age is " + user.age );
        }

        setTitle("Second Activity");
        nameText = findViewById(R.id.editTextDataToSendBack);

        findViewById(R.id.buttonSendBack).setOnClickListener( (v) -> {
            String enteredData = nameText.getText().toString();
            Intent intent = new Intent();
            intent.putExtra(MainActivity.DATA_ENTERED, enteredData);
            setResult(RESULT_OK,intent);
            finish();
        });

        findViewById(R.id.closeButton).setOnClickListener( (v) -> {
            finish();
            setResult( RESULT_CANCELED );
        });

        /*
        findViewById(R.id.closeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
         */
    }
}
