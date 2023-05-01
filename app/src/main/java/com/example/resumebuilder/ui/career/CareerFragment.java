package com.example.resumebuilder.ui.career;

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
import com.example.resumebuilder.data.Career;
import com.example.resumebuilder.databinding.FragmentCareerBinding;

public class CareerFragment extends Fragment {

    private FragmentCareerBinding binding;
    private CareerViewModel careerViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        careerViewModel =
                new ViewModelProvider(this).get(CareerViewModel.class);

        binding = FragmentCareerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.setViewModel(careerViewModel);
        binding.setLifecycleOwner(this);

        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button button = (Button) view.findViewById(R.id.button_save3);
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
        Career career = new Career();
        career.setNameofCompany(binding.nameofCompany.getText().toString());
        career.setJob(binding.job.getText().toString());
        career.setIntroduction(binding.introduction.getText().toString());
        career.setDetails(binding.detailsofJob.getText().toString());
        career.setStartDate(binding.startDate.getText().toString());
        career.setEndDate(binding.endDate.getText().toString());
        careerViewModel.SaveCareer(career);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
