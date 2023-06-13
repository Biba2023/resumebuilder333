package com.example.resumebuilder.ui.keySkills;

import android.content.Intent;
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
import com.example.resumebuilder.data.KeySkills;
import com.example.resumebuilder.databinding.FragmentSkillsBinding;
import com.example.resumebuilder.databinding.FragmentSkillsBinding;
import com.example.resumebuilder.ui.contact.ContactRecommendationsActivity;
import com.example.resumebuilder.ui.keySkills.KeySkillsViewModel;
import com.google.android.material.snackbar.Snackbar;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        TextView button_delete = binding.buttonDelete5;
        Button button_save = binding.buttonSave5;
        binding.buttonRecommendations5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KeySkillsRecommendationsActivity.class);
                startActivity(intent);
            }
        });
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeySkills keySkills = new KeySkills();
                keySkills.setKeySkills(binding.keySkills.getText().toString());
                keySkillsViewModel.SaveKeySkills(keySkills);
                Snackbar.make(view, "Данные успешно сохранены", Snackbar.LENGTH_SHORT).show();
            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.keySkills.setText("");
                KeySkills keySkills = new KeySkills();
                keySkills.setKeySkills(binding.keySkills.getText().toString());
                keySkillsViewModel.SaveKeySkills(keySkills);
                Snackbar.make(view, "Данные успешно удалены", Snackbar.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public void onPause() {
        super.onPause();
        KeySkills keySkills = new KeySkills();
        keySkills.setKeySkills(binding.keySkills.getText().toString());
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

