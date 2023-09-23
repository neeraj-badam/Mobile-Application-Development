package com.example.week4fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.week4fragments.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements CustomFragment.IListener {
    final String TAG = "demo";
    Boolean buttonsEnabled = true;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*  In the video you said it will crash because there is no setContentView Previously.
            Ask Professor: I tried to write this code below, in the video you said that it will crash may I know
            at what situations it will crash.
        */

        Log.d(TAG, "MainActivity: onCreate: Before setContentView");

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.buttonGoToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.textViewLabelShow.setText("Hola");

                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

//        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity: onCreate: after setContentView");

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.displayText, new FirstFragment(), "fragment")
                .commit();

        findViewById(R.id.buttonShowFirstFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("fragment");

                if(fragment != null){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .remove(fragment)
//                            .add(R.id.containerView,new FirstFragment())
//                            .replace(R.id.containerView, new FirstFragment())
                            .replace(R.id.containerView, CustomFragment.newInstance("First Fragment", Color.RED),"fragment")
                            .commit();
                }
                 */

                /*
                if(buttonsEnabled) {

                    CustomFragment fragment = (CustomFragment) getSupportFragmentManager().findFragmentByTag("fragment");

                    if (fragment != null) {
                        // This is the way of passing data from Activity to fragment,
                        // by creating a method instead of initializing when a fragment is created
                        fragment.updateValues("First Fragment", Color.MAGENTA);
                    }
                }
                */

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.displayText, CustomFragment.newInstance("First Fragment", Color.RED),"fragment")
                        .addToBackStack(null) // If we want to go back to previous page kind of versions
                        .commit();

                // If we want to programatically backstack
                // getSupportFragmentManager().popBackStack();
            }
        });

        findViewById(R.id.buttonShowSecondFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonsEnabled) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            // .replace(R.id.containerView, new SecondFragment(),"fragment")
                            .replace(R.id.displayText, CustomFragment.newInstance("Second Fragment", Color.GREEN), "fragment")
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
        findViewById(R.id.buttonShowThirdFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonsEnabled) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            // .replace(R.id.containerView, new ThirdFragment(),"fragment")
                            .replace(R.id.displayText, CustomFragment.newInstance("Third Fragment", Color.BLUE), "fragment")
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart: ");
    }

    @Override
    public void setButtonEnabled(boolean status) {
        buttonsEnabled = status;
    }
}

/*
    There are different ways of adding a fragment:
        Adding FragmentContainerView directly into the activity by dragging in XML -> Constraint Layout
        Give an ID to the layout you wanna add in the XML, then add it in JAVA code using getSupportFragmentManager
 */