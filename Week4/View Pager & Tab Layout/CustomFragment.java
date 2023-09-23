package com.example.week4viewpagerandtablayout;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_LABEL = "ARG_PARAM_LABEL";
    private static final String ARG_PARAM_COLOR = "ARG_PARAM_COLOR";

    // TODO: Rename and change types of parameters
    private String label;
    private int color;
    TextView textViewLabel;
    Switch switchEnable;
    IListener mListener;
    public CustomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CustomFragment newInstance(String label, int color) {
        CustomFragment fragment = new CustomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_LABEL, label);
        args.putInt(ARG_PARAM_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.label = getArguments().getString(ARG_PARAM_LABEL);
            this.color = getArguments().getInt(ARG_PARAM_COLOR);
        }
    }

    public void updateValues(String label, int color){
        this.label = label;
        this.color = color;

        textViewLabel.setText(this.label);
//        getView().setBackgroundColor(this.color);
        textViewLabel.setBackgroundColor(this.color);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom, container, false);

        textViewLabel = view.findViewById(R.id.textViewLabel);
        switchEnable = view.findViewById(R.id.switchEnable);

        switchEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mListener.setButtonEnabled(isChecked);
                if (isChecked){
                    Log.d("demo", "onCheckedChanged: On");
                } else{
                    Log.d("demo", "onCheckedChanged: Off");
                }
            }
        });

        textViewLabel.setText(this.label);

        textViewLabel.setBackgroundColor(this.color);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof IListener){
            mListener = (IListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement IListener");
        }
    }

    public interface IListener{
        void setButtonEnabled(boolean status);
    }
}