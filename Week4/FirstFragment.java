package com.example.week4fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week4fragments.databinding.FragmentFirstBinding;
import com.example.week4fragments.databinding.FragmentSecondBinding;

public class FirstFragment extends Fragment {

    final String TAG = "demo";
    TextView textView;
    FragmentFirstBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "FirstFragment: onCreate: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "FirstFragment: onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        // We can add buttons, in onCreateView or onActivityCreated, onActivityCreated this method is deprecated
        /*
        textView = view.findViewById(R.id.textView);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Button click", Toast.LENGTH_SHORT).show();

                textView.setText( textView.getText().toString() + "*" );
            }
        });
         */
        binding = FragmentFirstBinding.inflate(inflater, container, false);

//        return view;
        return binding.getRoot();
    }
    /*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Button click", Toast.LENGTH_SHORT).show();
            }
        });
        Log.d(TAG, "FirstFragment: onActivityCreated: ");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "FirstFragment: onAttach: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "FirstFragment: onResume: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "FirstFragment: onStart: ");
    }*/

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // If we are using binding we can use onViewCreated, i.e after the view is created
        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.buttonSubmit.setText( binding.editTextPersonName.getText().toString() );
            }
        });
    }
}