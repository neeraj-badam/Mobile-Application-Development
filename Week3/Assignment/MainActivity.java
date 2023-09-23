package com.example.week3assignment2;

/*
    a. Assignment #.            : 2
    b. File Name.               : Assignment2.zip
    c. Full name of the student : NeerajKumar Badam(801369013), Varun Tadepalli(801365164)
*/

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextName, editTextAge;
    TextView textViewTotalProgressSelected;
    ImageView iconHowAreYouFeeling;
    static Integer selectedIconValue, progressValue;
    static final String KEY_PROFILE = "PROFILE", KEY_ICON_VALUE = "ICON_VALUE";
    ActivityResultLauncher<Intent> startActivityForIcon = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if( result.getResultCode() == RESULT_OK ){
                        Intent data =result.getData();
                        selectedIconValue = data.getIntExtra(SelectMood.KEY_MOOD,0);
                        progressValue = data.getIntExtra(SelectMood.KEY_PROGRESS_VALUE,0);
                        textViewTotalProgressSelected.setText(progressValue+" out of 4");
                        iconHowAreYouFeeling.setImageResource(selectedIconValue);
                    } else if( result.getResultCode() == RESULT_CANCELED ){
                        /*
                        selectedIconValue = null;
                        iconHowAreYouFeeling.setImageResource(0);
                        textViewTotalProgressSelected.setText("");
                         */
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        iconHowAreYouFeeling = findViewById(R.id.iconHowAreYouFeeling);
        textViewTotalProgressSelected = findViewById(R.id.textViewTotalProgressSelected);
        textViewTotalProgressSelected.setText("");
        findViewById(R.id.buttonTellUs).setOnClickListener(this);
        findViewById(R.id.submitFormButton).setOnClickListener(this);

        setTitle("Main");

    }

    @Override
    public void onClick(@NonNull View view) {

        if( view.getId() == R.id.submitFormButton ){

            if( editTextName.getText().toString().isEmpty() ){
                Toast.makeText(MainActivity.this,"Please Enter your Name", Toast.LENGTH_LONG).show();
            } else if( editTextAge.getText().toString().isEmpty() ){
                Toast.makeText(MainActivity.this,"Please Enter your Age", Toast.LENGTH_LONG).show();
            } else if( selectedIconValue == null ){
                Toast.makeText(MainActivity.this,"Please Tell us How are you feeling", Toast.LENGTH_LONG).show();
            } else {
                String name = editTextName.getText().toString();
                Integer age = Integer.parseInt( editTextAge.getText().toString() );
                User user = new User(name,age,progressValue);
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra(KEY_PROFILE,user);
                intent.putExtra(KEY_ICON_VALUE, selectedIconValue);
                startActivity(intent);
            }
        } else {
            Intent intent = new Intent(MainActivity.this, SelectMood.class);
            startActivityForIcon.launch(intent);
        }
    }
}
/*
    Software process models:
        Plan driven             =>  waterfall
        Agile                   => Evolutionary
                                    -> Throwaway prototype
        Plan driven or Agile    => Re-used
        Plan driven             => Formal

        Principals of Agile
            Customer involvement
            Incremental Delivery
            People not process
            Embrace Change
            Maintain Simplicity
*/