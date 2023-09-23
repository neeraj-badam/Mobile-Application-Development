package com.example.week4fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultViewerActivity extends AppCompatActivity {

    TextView textViewResult;
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_viewer);

        textViewResult = findViewById(R.id.textViewResult);

        if( getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(MainActivity.CALCULATION_OBJECT)){
            Calculation obj = (Calculation) getIntent().getSerializableExtra(MainActivity.CALCULATION_OBJECT);
            Log.d("demo", "onClick: "+ obj.getNumberA()+", "+ obj.getOperation() + " ,"+obj.getNumberB());

            Double numA = Double.parseDouble(obj.getNumberA());
            Double numB = Double.parseDouble(obj.getNumberB());
            String operation = obj.getOperation();

            Double res = null;


            if(operation.equals("+")){
                res = numA + numB;
            } else if (operation.equals("-")){
                res = numA - numB;
            } else if (operation.equals("*")){
                res = numA * numB;
            } else if (operation.equals("/")){
                res = numA / numB;
            }

            textViewResult.setText( numA + " "+ obj.getOperation() + " "+ numB +" = "+ decimalFormat.format(res));

            findViewById(R.id.buttonClose).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        }
    }
}