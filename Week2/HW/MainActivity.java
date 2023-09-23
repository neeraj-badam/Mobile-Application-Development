package com.example.firstdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static ArrayList<Integer> drinkSize = new ArrayList<>();
    static ArrayList<Integer> alcoholPercent = new ArrayList<>();
    static Double bacLevel = 0.00;
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.weightButton).setOnClickListener(this);
        findViewById(R.id.addDrinkButton).setOnClickListener(this);
        SeekBar alcoholSeekBar = findViewById(R.id.alcoholSeekBar);
        alcoholSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView alcoholPercent = findViewById(R.id.alcoholPercent);
                alcoholPercent.setText( i + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        TextView selectedWeightText = findViewById(R.id.selectedWeightText);
        TextView statusText = findViewById(R.id.statusText);
        if(view.getId() == R.id.weightButton){
            TextView numberOfDrinksText = findViewById(R.id.numberOfDrinksText);
            TextView bacLevelText = findViewById(R.id.bacLevelText);
            EditText inputWeight = findViewById(R.id.inputWeight);
            RadioGroup radioGender = findViewById(R.id.radioGender);
            int checkedId = radioGender.getCheckedRadioButtonId();
            if( checkedId == R.id.radioFemale ) {
                selectedWeightText.setText(inputWeight.getText() + " lbs (Female)");
            } else {
                selectedWeightText.setText(inputWeight.getText() + " lbs (Male)");
            }
            inputWeight.setText("");
            drinkSize.clear();
            alcoholPercent.clear();
            numberOfDrinksText.setText("");
            bacLevelText.setText("");
            statusText.setText(R.string.safe_text);
            // statusText.setBackgroundColor(R.color.green);
            bacLevel = 0.00;
        } else if(view.getId() == R.id.addDrinkButton){
            if(String.valueOf(selectedWeightText.getText()).isEmpty()){
                Toast.makeText(this, "Please enter your weight and select your gender", Toast.LENGTH_SHORT).show();
                return;
            }
            TextView alcoholPercentText = findViewById(R.id.alcoholPercent);
            RadioGroup radioDrinkSizeGroup = findViewById(R.id.radioDrinkSizeGroup);

            TextView numberOfDrinksText = findViewById(R.id.numberOfDrinksText);
            TextView bacLevelText = findViewById(R.id.bacLevelText);

            int percent = Integer.parseInt(String.valueOf(alcoholPercentText.getText()).split("%")[0]);
            int selectedDrinkSize = 0;
            if(radioDrinkSizeGroup.getCheckedRadioButtonId() == R.id.radioOneOZ){
                selectedDrinkSize = 1;
            } else if(radioDrinkSizeGroup.getCheckedRadioButtonId() == R.id.radioFiveOZ){
                selectedDrinkSize = 5;
            } else if(radioDrinkSizeGroup.getCheckedRadioButtonId() == R.id.radioTwelveOZ){
                selectedDrinkSize = 12;
            }
            drinkSize.add( selectedDrinkSize );
            alcoholPercent.add(percent);

            String data[] = String.valueOf(selectedWeightText.getText()).split("lbs");
            Double weight = Double.valueOf(data[0]);
            Double rForGender;
            if(data[1].contains("Female")){
                rForGender = 0.66;
            } else{
                rForGender = 0.73;
            }

            bacLevel += ((Double) (1.00 * percent * selectedDrinkSize))/100;

            Double BAC = ( bacLevel * 5.14 / (weight * rForGender));
            numberOfDrinksText.setText( drinkSize.size() + "");
            bacLevelText.setText(decimalFormat.format(BAC)+"");

            if(0 <= BAC && BAC <= 0.08){
                statusText.setText(R.string.safe_text);
                statusText.setBackgroundResource(R.color.green);
            } else if( 0.08 < BAC && BAC <= 0.2){
                statusText.setText(R.string.be_careful);
                statusText.setBackgroundResource(R.color.orange);
            } else if(BAC > 0.2){
                statusText.setText(R.string.over_the_limt);
                statusText.setBackgroundResource(R.color.red);
            }

        }
    }
}
