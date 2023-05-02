package com.example.resumebuilder.ui.interests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.resumebuilder.R;
import com.example.resumebuilder.data.Interests;
import com.example.resumebuilder.data.PersonalInfo;
import com.example.resumebuilder.databinding.FragmentInterestsBinding;
import com.example.resumebuilder.databinding.FragmentPersonalBinding;
import com.example.resumebuilder.ui.personalInfo.PersonalInfoViewModel;

public class InterestsFragment extends Fragment {
    private FragmentInterestsBinding binding;
    private InterestsViewModel interestsViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        interestsViewModel =
                new ViewModelProvider(this).get(InterestsViewModel.class);

        binding = FragmentInterestsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.setViewModel(interestsViewModel);
        binding.setLifecycleOwner(this);

        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        TextView button_delete = binding.buttonDelete7;
        Button button_save = binding.buttonSave7;
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.interests.setText("");
                Interests interests = new Interests();
                interests.setInterests(binding.interests.getText().toString());
                interestsViewModel.SaveInterests(interests);
            }
        });
    }
    @Override
    public void onPause() {
        super.onPause();
        Interests interests = new Interests();
        interests.setInterests(binding.interests.getText().toString());
        interestsViewModel.SaveInterests(interests);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

