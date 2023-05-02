package com.example.resumebuilder.ui.photo;

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

import com.example.resumebuilder.databinding.FragmentPersonalBinding;
import com.example.resumebuilder.databinding.FragmentPhotoBinding;
import com.example.resumebuilder.ui.personalInfo.PersonalInfoViewModel;

public class PhotoFragment extends Fragment {
    private FragmentPhotoBinding binding;
    private PhotoViewModel photoViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        photoViewModel =
                new ViewModelProvider(this).get(PhotoViewModel.class);

        binding = FragmentPhotoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button button = (Button) view.findViewById(R.id.button_save8);
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

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


