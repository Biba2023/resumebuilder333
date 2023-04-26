package com.example.resumebuilder.ui.personalInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.resumebuilder.data.PersonalInfo;
import com.example.resumebuilder.databinding.FragmentPersonalBinding;

public class PersonalInfoFragment extends Fragment {

    private FragmentPersonalBinding binding;
    private PersonalInfoViewModel personalInfoViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personalInfoViewModel =
                new ViewModelProvider(this).get(PersonalInfoViewModel.class);

        binding = FragmentPersonalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.setViewModel(personalInfoViewModel);
        binding.setLifecycleOwner(this);

        return root;
    }
    @Override
    public void onPause() {
        super.onPause();
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setKeyExperience(binding.keyExperience.getText().toString());
        personalInfoViewModel.SavePersonalInfo(personalInfo);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}