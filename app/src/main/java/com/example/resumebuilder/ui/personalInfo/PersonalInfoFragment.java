package com.example.resumebuilder.ui.personalInfo;

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
import com.example.resumebuilder.data.PersonalInfo;
import com.example.resumebuilder.databinding.FragmentPersonalBinding;
import com.example.resumebuilder.ui.contact.ContactRecommendationsActivity;
import com.google.android.material.snackbar.Snackbar;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        TextView button_delete = binding.buttonDelete2;
        Button button_save = binding.buttonSave2;
        binding.buttonRecommendations6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonalInfoRecommendationsActivity.class);
                startActivity(intent);
            }
        });
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalInfo personalInfo = new PersonalInfo();
                personalInfo.setKeyExperience(binding.keyExperience.getText().toString());
                personalInfoViewModel.SavePersonalInfo(personalInfo);
                Snackbar.make(view, "Данные успешно сохранены", Snackbar.LENGTH_SHORT).show();
            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.keyExperience.setText("");
                PersonalInfo personalInfo = new PersonalInfo();
                personalInfo.setKeyExperience(binding.keyExperience.getText().toString());
                personalInfoViewModel.SavePersonalInfo(personalInfo);
                Snackbar.make(view, "Данные успешно удалены", Snackbar.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public void onPause() {
        super.onPause();
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setKeyExperience(binding.keyExperience.getText().toString());

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}