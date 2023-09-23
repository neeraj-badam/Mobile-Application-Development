package com.example.week4assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week4assignment3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainFragment.MainInterface, SelectMoodFragment.SelectMoodInterface, ProfileFragment.ProfileInterface {

    ActivityMainBinding binding;
    Integer selectedMood;
    EditText editTextName, editTextAge;
    TextView textViewTotalProgressSelected;
    ImageView iconHowAreYouFeeling;
    static Integer selectedIconValue, progressValue;
    static final String KEY_PROFILE = "PROFILE", KEY_ICON_VALUE = "ICON_VALUE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate( getLayoutInflater() );
        setContentView( binding.getRoot() );



        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.containerViewFragment, new MainFragment(),"MainFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToMoodSelection() {
        Log.d("demo", "goToMoodSelection: DODO");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerViewFragment, new SelectMoodFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToProfileSelection(User user) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerViewFragment,ProfileFragment.newInstance(user))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToMainFragment() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void goToMainFragment(Integer progressValue,Integer selectedMood) {
        this.selectedMood = selectedMood;
        MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MainFragment");
        if (fragment != null){
            fragment.setProgressValue(progressValue);
            fragment.setMood(selectedMood);
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void goBackToMainFragment() {
        getSupportFragmentManager().popBackStack();
    }
}