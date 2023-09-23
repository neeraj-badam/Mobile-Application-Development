package com.example.week4fragments;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final String TAG = "demo";
    TextView textViewOperation;
    EditText numberA, numberB;

    static final String CALCULATION_OBJECT = "OPERATION";
    ActivityResultLauncher<Intent> startActivityForOperation = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                        String operation = data.getStringExtra(PickOperationActivity.OPERATION_LABEL);
                        textViewOperation.setText(operation);
                    }
                }
            }

    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.d(TAG, "onCreate: MainActivity Before setContentView");
        setContentView(R.layout.activity_main);
//        Log.d(TAG, "onCreate: MainActivity After setContentView");

        textViewOperation = findViewById(R.id.textViewOperation);
        numberA = findViewById(R.id.numberA);
        numberB = findViewById(R.id.numberB);

        findViewById(R.id.buttonPickOperation).setOnClickListener(this);

        findViewById(R.id.buttonClear).setOnClickListener(this);

        findViewById(R.id.buttonCalculate).setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonPickOperation){
            Intent intent = new Intent(MainActivity.this, PickOperationActivity.class);
            startActivityForOperation.launch(intent);
        } else if(view.getId() == R.id.buttonClear){
            numberA.setText("");
            numberB.setText("");
            textViewOperation.setText("?");
        } else if(view.getId() == R.id.buttonCalculate){

            if( numberA.getText().toString().isEmpty() ){
                Toast.makeText(MainActivity.this, "Please enter a valid number for Number A", Toast.LENGTH_SHORT).show();
            } else if (numberB.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter a valid number for Number B", Toast.LENGTH_SHORT).show();
            } else if(textViewOperation.getText().toString().equals("?")){
                Toast.makeText(MainActivity.this, "Please pick an operation", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, ResultViewerActivity.class);

                Log.d(TAG, "onClick: "+ textViewOperation.getText().toString());

                Calculation object = new Calculation(
                        numberA.getText().toString(),
                        numberB.getText().toString(),
                        textViewOperation.getText().toString()
                );
                Double num = Double.parseDouble(object.getNumberB());
                Log.d(TAG, "onClick: "+ num);

                if(num == 0 && object.getOperation().equals("/")){
                    Toast.makeText(MainActivity.this, "Number A can't be divided by zero", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra(CALCULATION_OBJECT, object);
                    startActivity(intent);
                }
            }

        }

    }

    /*

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: MainActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: MainActivity");
    }
     */
}