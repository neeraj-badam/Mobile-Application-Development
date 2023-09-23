package com.example.week3assignment2;

/*
    a. Assignment #.            : 2
    b. File Name.               : Assignment2.zip
    c. Full name of the student : NeerajKumar Badam(801369013), Varun Tadepalli(801365164)
*/

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewShowProfileName, textViewShowProfileAge, textViewShowTotalOutOfFour, textViewSelectedMoodText;
    ImageView profileSelectedMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewShowProfileName = findViewById(R.id.textViewShowProfileName);
        textViewShowProfileAge = findViewById(R.id.textViewShowProfileAge);
        textViewShowTotalOutOfFour = findViewById(R.id.textViewShowTotalOutOfFour);
        textViewSelectedMoodText = findViewById(R.id.textViewSelectedMoodText);
        profileSelectedMood = findViewById(R.id.profileSelectedMood);

        setTitle("Profile");

        findViewById(R.id.buttonBack).setOnClickListener(this);

        if( getIntent() != null && getIntent().hasExtra(MainActivity.KEY_PROFILE) ){
            User user = (User) getIntent().getSerializableExtra(MainActivity.KEY_PROFILE);
            Integer moodValue = user.getMoodValue();
            String mood = null;
            textViewShowProfileName.setText( user.getName() );
            textViewShowProfileAge.setText( user.getAge()+ " Years Old" );
            textViewShowTotalOutOfFour.setText( user.getMoodValue() + " out of 4" );
            profileSelectedMood.setImageResource( getIntent().getIntExtra(MainActivity.KEY_ICON_VALUE,0) );
            if( moodValue == 0){
                mood = "Not Well";
            } else if( moodValue == 1){
                mood = "Sad";
            } else if( moodValue == 2){
                mood = "Ok";
            } else if( moodValue == 3){
                mood = "Good";
            } else if( moodValue == 4){
                mood = "Very Good";
            }
            textViewSelectedMoodText.setText( mood );
        }

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}