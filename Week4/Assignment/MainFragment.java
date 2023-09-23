package com.example.week4assignment3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week4assignment3.databinding.FragmentMainBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    FragmentMainBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private static Integer mood;

    public static void setMood(Integer mood) {
        MainFragment.mood = mood;
    }

    public static void setProgressValue(Integer progressValue) {
        MainFragment.progressValue = progressValue;
    }

    private static Integer progressValue;
    MainInterface currentInterface;
    TextView textViewTotalProgressSelected;
    ImageView iconHowAreYouFeeling;
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonTellUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInterface.goToMoodSelection();
            }
        });

        if (this.progressValue == null){
            binding.textViewTotalProgressSelected.setText("");
        } else{
            binding.textViewTotalProgressSelected.setText(this.progressValue + " out of 4");
            binding.iconHowAreYouFeeling.setImageResource(this.mood);
        }
        binding.submitFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextName = binding.editTextName;
                EditText editTextAge = binding.editTextAge;
                TextView textViewTotalProgressSelected = binding.textViewTotalProgressSelected;
                ImageView iconHowAreYouFeeling = binding.iconHowAreYouFeeling;
                if( editTextName.getText().toString().isEmpty() ){
                    Toast.makeText(getActivity(),"Please Enter your Name", Toast.LENGTH_LONG).show();
                } else if( editTextAge.getText().toString().isEmpty() ){
                    Toast.makeText(getActivity(),"Please Enter your Age", Toast.LENGTH_LONG).show();
                } else if( textViewTotalProgressSelected.getText().toString().isEmpty() ){
                    Toast.makeText(getActivity(),"Please Tell us How are you feeling", Toast.LENGTH_LONG).show();
                } else {
                    String name = binding.editTextName.getText().toString();
                    Integer age = Integer.valueOf(binding.editTextAge.getText().toString());
                    Integer moodValue = Integer.valueOf(binding.textViewTotalProgressSelected.getText().toString().substring(0,1));
                    User user = new User(name, age, moodValue,mood);
                    currentInterface.goToProfileSelection(user);
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if( context instanceof MainInterface){
            currentInterface = (MainInterface) context;
        } else {
            throw new RuntimeException(context.toString() + " Must implement MainInterface");
        }
    }

    public interface MainInterface{
        void goToMoodSelection();
        void goToProfileSelection(User user);
    }
}