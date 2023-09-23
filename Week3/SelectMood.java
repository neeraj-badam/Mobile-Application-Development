package com.example.week3assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class SelectMood extends AppCompatActivity {

    SeekBar seekBarProgress;
    ImageView imageViewMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mood);

        imageViewMood = findViewById(R.id.imageViewMood);
        seekBarProgress = findViewById(R.id.seekBarProgress);

        seekBarProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean b) {
                if(progressValue == 0){
                    imageViewMood.setImageResource(R.drawable.pensive);
                } else if (progressValue == 1) {
                    
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
