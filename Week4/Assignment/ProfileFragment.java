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

import com.example.week4assignment3.databinding.FragmentProfileBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    ProfileInterface profileInterface;

    private static final String ARG_PARAM_USER = "USER";
    // TODO: Rename and change types of parameters
    private static User user;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(User user) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = (User) getArguments().getSerializable(ARG_PARAM_USER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("demo", "onViewCreated: "+user);
        binding.textViewShowProfileName.setText(user.getName());
        binding.textViewShowProfileAge.setText(user.getAge()+"");
        Integer moodValue = user.getMoodValue();
        String mood = null;
        binding.textViewShowTotalOutOfFour.setText(user.getMoodValue()+" out of 4");
        binding.profileSelectedMood.setImageResource(user.getMoodImageValue());
        if( moodValue == 0){
            mood = "Not Well";
        } else if( moodValue == 1){
            mood = "Sad";
        } else if( moodValue == 2){
            mood = "Ok";
        } else if( moodValue == 3){
            mood = "Good";
        } else if( moodValue == 4){
            mood = "Very Good";
        }
        binding.textViewSelectedMoodText.setText( mood );

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileInterface.goBackToMainFragment();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if( context instanceof ProfileInterface){
            profileInterface = (ProfileInterface) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ProfileInterface");
        }
    }

    public interface ProfileInterface{
        void goBackToMainFragment();
    }
}