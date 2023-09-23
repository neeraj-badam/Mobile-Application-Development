package com.example.week4fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class PickOperationActivity extends AppCompatActivity {

    RadioGroup radioGroupOperation;
    static final String OPERATION_LABEL = "OPERATION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_operation);


        radioGroupOperation = findViewById(R.id.radioGroupOperation);

        findViewById(R.id.buttonSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int operationId = radioGroupOperation.getCheckedRadioButtonId();
                Intent intent = new Intent();
                if(operationId == R.id.radioButtonAdd){
                    intent.putExtra(OPERATION_LABEL,"+");
                } else if(operationId == R.id.radioSubtract){
                    intent.putExtra(OPERATION_LABEL,"-");
                } else if(operationId == R.id.radioMultiply){
                    intent.putExtra(OPERATION_LABEL,"*");
                } else if(operationId == R.id.radioButtonDivide){
                    intent.putExtra(OPERATION_LABEL,"/");
                }
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}