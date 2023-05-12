package com.example.resumebuilder.ui.projects;

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
import com.example.resumebuilder.data.Projects;
import com.example.resumebuilder.databinding.FragmentEducationBinding;
import com.example.resumebuilder.databinding.FragmentProjectsBinding;
import com.example.resumebuilder.ui.education.EducationViewModel;

public class ProjectsFragment extends Fragment {
    private FragmentProjectsBinding binding;
    private ProjectsViewModel projectsViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        projectsViewModel =
                new ViewModelProvider(this).get(ProjectsViewModel.class);

        binding = FragmentProjectsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.setViewModel(projectsViewModel);
        binding.setLifecycleOwner(this);

        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        TextView button_delete = binding.buttonDelete6;
        Button button_save = binding.buttonSave6;
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Projects projects = new Projects();
                projects.setProject(binding.nameofProject.getText().toString());
                projects.setDetails(binding.detailsofProject.getText().toString());
                projects.setStartDate(binding.startDateofProject.getText().toString());
                projects.setEndDate(binding.endDateofProject.getText().toString());
                projectsViewModel.SaveProjects(projects);
            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.nameofProject.setText("");
                binding.detailsofProject.setText("");
                binding.startDateofProject.setText("");
                binding.endDateofProject.setText("");
                Projects projects = new Projects();
                projects.setProject(binding.nameofProject.getText().toString());
                projects.setDetails(binding.detailsofProject.getText().toString());
                projects.setStartDate(binding.startDateofProject.getText().toString());
                projects.setEndDate(binding.endDateofProject.getText().toString());
                projectsViewModel.SaveProjects(projects);
            }
        });
    }
    @Override
    public void onPause() {
        super.onPause();
        Projects projects = new Projects();
        projects.setProject(binding.nameofProject.getText().toString());
        projects.setDetails(binding.detailsofProject.getText().toString());
        projects.setStartDate(binding.startDateofProject.getText().toString());
        projects.setEndDate(binding.endDateofProject.getText().toString());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
