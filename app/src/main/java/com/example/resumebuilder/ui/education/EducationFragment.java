package com.example.resumebuilder.ui.education;

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
import com.example.resumebuilder.data.Education;
import com.example.resumebuilder.databinding.FragmentEducationBinding;
import com.example.resumebuilder.ui.contact.ContactRecommendationsActivity;
import com.google.android.material.snackbar.Snackbar;


public class EducationFragment extends Fragment {
    private FragmentEducationBinding binding;
    private EducationViewModel educationViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        educationViewModel =
                new ViewModelProvider(this).get(EducationViewModel.class);

        binding = FragmentEducationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.setViewModel(educationViewModel);
        binding.setLifecycleOwner(this);

        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        TextView button_delete = binding.buttonDelete4;
        Button button_save = binding.buttonSave4;
        binding.buttonRecommendations3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EducationRecommendationsActivity.class);
                startActivity(intent);
            }
        });
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Education education = new Education();
                education.setUniversity(binding.nameofUniversity.getText().toString());
                education.setQualification(binding.qualofication.getText().toString());
                education.setGrade(binding.grade.getText().toString());
                education.setDetails(binding.detailsofEducation.getText().toString());
                education.setStartDate(binding.startDateofEducation.getText().toString());
                education.setEndDate(binding.endDateofeducation.getText().toString());
                educationViewModel.SaveEducation(education);
                Snackbar.make(view, "Данные успешно сохранены", Snackbar.LENGTH_SHORT).show();
            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.nameofUniversity.setText("");
                binding.qualofication.setText("");
                binding.grade.setText("");
                binding.detailsofEducation.setText("");
                binding.startDateofEducation.setText("");
                binding.endDateofeducation.setText("");
                Education education = new Education();
                education.setUniversity(binding.nameofUniversity.getText().toString());
                education.setQualification(binding.qualofication.getText().toString());
                education.setGrade(binding.grade.getText().toString());
                education.setDetails(binding.detailsofEducation.getText().toString());
                education.setStartDate(binding.startDateofEducation.getText().toString());
                education.setEndDate(binding.endDateofeducation.getText().toString());
                educationViewModel.SaveEducation(education);
                Snackbar.make(view, "Данные успешно удалены", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onPause() {
        super.onPause();
        Education education = new Education();
        education.setUniversity(binding.nameofUniversity.getText().toString());
        education.setQualification(binding.qualofication.getText().toString());
        education.setGrade(binding.grade.getText().toString());
        education.setDetails(binding.detailsofEducation.getText().toString());
        education.setStartDate(binding.startDateofEducation.getText().toString());
        education.setEndDate(binding.endDateofeducation.getText().toString());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
