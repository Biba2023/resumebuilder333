package com.example.resumebuilder.ui.keySkills;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.resumebuilder.data.KeySkills;
import com.example.resumebuilder.databinding.FragmentSkillsBinding;
import com.example.resumebuilder.databinding.FragmentSkillsBinding;
import com.example.resumebuilder.ui.keySkills.KeySkillsViewModel;

public class KeySkillsFragment extends Fragment {
    private FragmentSkillsBinding binding;
    private KeySkillsViewModel keySkillsViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        keySkillsViewModel =
                new ViewModelProvider(this).get(KeySkillsViewModel.class);

        binding = FragmentSkillsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.setViewModel(keySkillsViewModel);
        binding.setLifecycleOwner(this);

        return root;
    }
    @Override
    public void onPause() {
        super.onPause();
        KeySkills keySkills = new KeySkills();
        keySkills.setKeySkills(binding.keySkills.getText().toString());
        keySkillsViewModel.SaveKeySkills(keySkills);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

