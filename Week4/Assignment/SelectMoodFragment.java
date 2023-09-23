package com.example.week4assignment3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.week4assignment3.databinding.FragmentSelectMoodBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectMoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectMoodFragment extends Fragment implements View.OnClickListener {
    FragmentSelectMoodBinding binding;


    SeekBar seekBarProgress;
    ImageView imageViewMood;
    TextView textViewProgress;
    static Integer selectedMood;
    static final String KEY_MOOD = "MOOD", KEY_PROGRESS_VALUE = "PROGRESS_VALUE";
    SelectMoodInterface moodSelection;
    public SelectMoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectMoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectMoodFragment newInstance(String param1, String param2) {
        SelectMoodFragment fragment = new SelectMoodFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSelectMoodBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageViewMood = binding.imageViewMood;
        seekBarProgress = binding.seekBarProgress;
        textViewProgress = binding.textViewProgress;

        imageViewMood.setImageResource(R.drawable.neutral_face);
        seekBarProgress.setProgress(2);
        getActivity().setTitle("Select Mood");

        seekBarProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean b) {
                textViewProgress.setText(progressValue+"");
                if(progressValue == 0){
                    imageViewMood.setImageResource(R.drawable.pensive);
                } else if (progressValue == 1) {
                    imageViewMood.setImageResource(R.drawable.sad);
                } else if (progressValue == 2) {
                    imageViewMood.setImageResource(R.drawable.neutral_face);
                } else if (progressValue == 3) {
                    imageViewMood.setImageResource(R.drawable.smiling);
                } else if (progressValue == 4) {
                    imageViewMood.setImageResource(R.drawable.grinning);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.buttonSubmitMood.setOnClickListener(this);
        binding.buttonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonCancel){
            moodSelection.goToMainFragment();
        } else {
            Integer progressValue = seekBarProgress.getProgress();
            if (progressValue == 0) {
                selectedMood = R.drawable.pensive;
            } else if (progressValue == 1) {
                selectedMood = R.drawable.sad;
            } else if (progressValue == 2) {
                selectedMood = R.drawable.neutral_face;
            } else if (progressValue == 3) {
                selectedMood = R.drawable.smiling;
            } else if (progressValue == 4) {
                selectedMood = R.drawable.grinning;
            }
            moodSelection.goToMainFragment(progressValue,selectedMood);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof SelectMoodInterface){
            moodSelection = (SelectMoodInterface) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement SelectMoodInterface");
        }
    }

    public interface SelectMoodInterface{
        void goToMainFragment();
        void goToMainFragment(Integer progressValue,Integer selectedMood);
    }
}