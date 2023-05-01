package com.example.resumebuilder.ui.interests;

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
        Button button = (Button) view.findViewById(R.id.button_save7);
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

