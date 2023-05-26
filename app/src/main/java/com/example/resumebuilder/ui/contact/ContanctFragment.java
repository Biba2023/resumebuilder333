package com.example.resumebuilder.ui.contact;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import com.example.resumebuilder.MainActivity;
import com.example.resumebuilder.R;
import com.example.resumebuilder.data.ContactInfo;
import com.example.resumebuilder.databinding.FragmentContactBinding;
import com.google.android.material.snackbar.Snackbar;

public class ContanctFragment extends Fragment{

    private FragmentContactBinding binding;
    private ContactViewModel contactViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactViewModel =
                new ViewModelProvider(this).get(ContactViewModel.class);

        binding = FragmentContactBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.setViewModel(contactViewModel);
        binding.setLifecycleOwner(this);




        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        TextView button_delete = binding.buttonDelete1;
        Button button_save = binding.buttonSave1;
        binding.buttonRecommendations1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactInfo contactInfo = new ContactInfo();
                contactInfo.setName(binding.fio.getText().toString());
                contactInfo.setEmail(binding.email.getText().toString());
                contactInfo.setTelephone(binding.telephone.getText().toString());
                contactInfo.setAddress(binding.address.getText().toString());
                contactInfo.setDateOfBirth(binding.dateOfBirth.getText().toString());
                contactViewModel.SaveContact(contactInfo);
                Snackbar.make(view, "Данные успешно сохранены", Snackbar.LENGTH_SHORT).show();
            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactInfo contactInfo = new ContactInfo();
                binding.fio.setText("");
                binding.email.setText("");
                binding.telephone.setText("");
                binding.address.setText("");
                binding.dateOfBirth.setText("");
                contactInfo.setName(binding.fio.getText().toString());
                contactInfo.setEmail(binding.email.getText().toString());
                contactInfo.setTelephone(binding.telephone.getText().toString());
                contactInfo.setAddress(binding.address.getText().toString());
                contactInfo.setDateOfBirth(binding.dateOfBirth.getText().toString());
                contactViewModel.SaveContact(contactInfo);
                Snackbar.make(view, "Данные успешно удалены", Snackbar.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public void onPause() {
        super.onPause();
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setName(binding.fio.getText().toString());
        contactInfo.setEmail(binding.email.getText().toString());
        contactInfo.setTelephone(binding.telephone.getText().toString());
        contactInfo.setAddress(binding.address.getText().toString());
        contactInfo.setDateOfBirth(binding.dateOfBirth.getText().toString());


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}