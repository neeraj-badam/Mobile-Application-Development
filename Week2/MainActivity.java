package com.example.firstdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

/*
public class MainActivity extends AppCompatActivity {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fivePercentDiscountButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findPercent(5);
            }
        });
        findViewById(R.id.tenPercentDiscountButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findPercent(10);
            }
        });
        findViewById(R.id.fifteenPercentDiscountButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findPercent(15);
            }
        });
        findViewById(R.id.twentyPercentDiscountButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findPercent(20);
            }
        });
        findViewById(R.id.fiftyPercentDiscountButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findPercent(50);
            }
        });
        findViewById(R.id.clearButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView discountedPercentValue = findViewById(R.id.discountedPercentValue);
                TextView discountedPriceValue = findViewById(R.id.discountedPriceValue);
                discountedPercentValue.setText("");
                discountedPriceValue.setText( "");
            }
        });
    }
    void findPercent(int percent){
        EditText ticketPrice =(EditText) findViewById(R.id.ticketPriceValue);
        String price = String.valueOf(ticketPrice.getText());

        if(price.isEmpty()){
            Toast.makeText(this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
        } else {
            TextView discountedPercentValue = findViewById(R.id.discountedPercentValue);
            TextView discountedPriceValue = findViewById(R.id.discountedPriceValue);
            Double result = Double.valueOf(price);
            result = result - result * (Double) (percent/100.00);
            discountedPercentValue.setText(String.valueOf(percent));
            discountedPriceValue.setText( String.valueOf( decimalFormat.format(result) ) );
        }
    }
}
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.fivePercentDiscountButton).setOnClickListener(this);
        findViewById(R.id.tenPercentDiscountButton).setOnClickListener(this);
        findViewById(R.id.fifteenPercentDiscountButton).setOnClickListener(this);
        findViewById(R.id.twentyPercentDiscountButton).setOnClickListener(this);
        findViewById(R.id.fiftyPercentDiscountButton).setOnClickListener(this);
        findViewById(R.id.clearButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText ticketPrice =(EditText) findViewById(R.id.ticketPriceValue);
        String price = String.valueOf(ticketPrice.getText());
        TextView discountedPercentValue = findViewById(R.id.discountedPercentValue);
        TextView discountedPriceValue = findViewById(R.id.discountedPriceValue);
        Integer percent = null;
        if(view.getId() == R.id.fivePercentDiscountButton){
            percent = 5;
        } else if(view.getId() == R.id.tenPercentDiscountButton){
            percent = 10;
        } else if(view.getId() == R.id.fifteenPercentDiscountButton){
            percent = 15;
        } else if(view.getId() == R.id.twentyPercentDiscountButton){
            percent = 20;
        } else if(view.getId() == R.id.fiftyPercentDiscountButton){
            percent = 50;
        } else if(view.getId() == R.id.clearButton){
            ticketPrice.setText("");
            discountedPercentValue.setText("");
            discountedPriceValue.setText("");
            return;
        }
        if(price.isEmpty()){
            Toast.makeText(this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
        } else{
            Double result = Double.valueOf(price);
            result = result - result * (Double) (percent/100.00);
            discountedPercentValue.setText(String.valueOf(percent));
            discountedPriceValue.setText( String.valueOf( decimalFormat.format(result) ) );
        }
    }
}
