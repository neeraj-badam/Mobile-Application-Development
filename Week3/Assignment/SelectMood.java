package com.example.week3assignment2;

/*
    a. Assignment #.            : 2
    b. File Name.               : Assignment2.zip
    c. Full name of the student : NeerajKumar Badam(801369013), Varun Tadepalli(801365164)
*/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class SelectMood extends AppCompatActivity implements View.OnClickListener {

    SeekBar seekBarProgress;
    ImageView imageViewMood;
    TextView textViewProgress;
    static Integer selectedMood;
    static final String KEY_MOOD = "MOOD", KEY_PROGRESS_VALUE = "PROGRESS_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mood);

        imageViewMood = findViewById(R.id.imageViewMood);
        seekBarProgress = findViewById(R.id.seekBarProgress);
        textViewProgress = findViewById(R.id.textViewProgress);

        imageViewMood.setImageResource(R.drawable.neutral_face);
        seekBarProgress.setProgress(2);
        setTitle("Select Mood");

        seekBarProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean b) {
                textViewProgress.setText(progressValue+"");
                if(progressValue == 0){
                    imageViewMood.setImageResource(R.drawable.pensive);
                } else if (progressValue == 1) {
                    imageViewMood.setImageResource(R.drawable.sad);
                } else if (progressValue == 2) {
                    imageViewMood.setImageResource(R.drawable.neutral_face);
                } else if (progressValue == 3) {
                    imageViewMood.setImageResource(R.drawable.smiling);
                } else if (progressValue == 4) {
                    imageViewMood.setImageResource(R.drawable.grinning);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        findViewById(R.id.buttonSubmitMood).setOnClickListener(this);
        findViewById(R.id.buttonCancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Integer progressValue = seekBarProgress.getProgress();
        if(progressValue == 0){
            selectedMood = R.drawable.pensive;
        } else if (progressValue == 1) {
            selectedMood = R.drawable.sad;
        } else if (progressValue == 2) {
            selectedMood = R.drawable.neutral_face;
        } else if (progressValue == 3) {
            selectedMood = R.drawable.smiling;
        } else if (progressValue == 4) {
            selectedMood = R.drawable.grinning;
        }
        Intent intent = new Intent();
        if( view.getId() == R.id.buttonSubmitMood ){
            intent.putExtra(KEY_PROGRESS_VALUE,progressValue);
            intent.putExtra( KEY_MOOD, selectedMood );
            setResult(RESULT_OK,intent);
        } else{
            setResult(RESULT_CANCELED);
        }
        finish();
    }
}