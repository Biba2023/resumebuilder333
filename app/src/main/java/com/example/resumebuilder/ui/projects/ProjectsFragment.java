package com.example.resumebuilder.ui.projects;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        Button button = (Button) view.findViewById(R.id.button_save6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "jkkkk", Toast.LENGTH_SHORT).show();
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
        projectsViewModel.SaveProjects(projects);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
