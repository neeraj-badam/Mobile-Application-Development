package com.example.week3implementation;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String TAG = "demo";
    final static public String NAME_KEY = "NAME";
    final static public String USER_KEY = "USER";
    final static public String USERS_KEY = "USERS";
    final static public String PARCELABLE_USER_KEY = "USER";
    final static public int REQ_CODE = 200;
    final static String DATA_ENTERED = "DATA_ENTERED";
    TextView textViewDataBack;

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if( result != null && result.getResultCode() == RESULT_OK ){
                if( result.getData() != null && result.getData().hasExtra( DATA_ENTERED ) ){

                    String enteredData = result.getData().getStringExtra(DATA_ENTERED).toString();
                    Log.d(TAG, "onActivityResult: " + enteredData);
                    textViewDataBack.setText("Hola : " + enteredData);

                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        setTitle("Main Activity");
        textViewDataBack = findViewById(R.id.textViewDataBack);
        findViewById(R.id.secondActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                implicit intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                 */
                /*
                Explicit intent
                Intent intent = new Intent("com.example.week3implementation.intent.action.VIEW");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);
                */
                /*
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(NAME_KEY,"Bob Smith");

                intent.putExtra(USER_KEY, new User("Neeraj", 23));

                ArrayList<User> users = new ArrayList<>();
                users.add(new User("Abhi",23));
                users.add(new User("Ram", 40));

                intent.putExtra(USERS_KEY, users);

                intent.putExtra(PARCELABLE_USER_KEY,new User("Parcelable",25));


                startActivity(intent);
                 */
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

//                startActivityForResult(intent, REQ_CODE);

                startForResult.launch(intent);

            }
        });

        /*
        findViewById(R.id.alertButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Error")
                        .setMessage("Unable to do!!")
                        .setPositiveButton("Hola Congo You are good to go", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setNegativeButton("Sorry we can't do it", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setNeutralButton("Kya karu mei marjao", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.create().show();
            }
        });*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: ");

        if(requestCode == REQ_CODE) {
            if (resultCode == RESULT_OK) {
                if (data != null && data.hasExtra(DATA_ENTERED)) {
                    String enteredData = data.getStringExtra(DATA_ENTERED).toString();
                    Log.d(TAG, "onActivityResult: " + enteredData);
                    textViewDataBack.setText(enteredData);
                }
                Log.d(TAG, "onActivityResult: RESULT_OK");
            } else if (resultCode == RESULT_CANCELED) {
                Log.d(TAG, "onActivityResult: RESULT_CANCELED");
            }
        }
    }
}
