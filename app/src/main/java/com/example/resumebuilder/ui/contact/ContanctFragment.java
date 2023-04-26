package com.example.resumebuilder.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.resumebuilder.data.ContactInfo;
import com.example.resumebuilder.databinding.FragmentContactBinding;

public class ContanctFragment extends Fragment {

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
    public void onPause() {
        super.onPause();
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setName(binding.fio.getText().toString());
        contactInfo.setEmail(binding.email.getText().toString());
        contactInfo.setTelephone(binding.telephone.getText().toString());
        contactInfo.setAddress(binding.address.getText().toString());
        contactInfo.setDateOfBirth(binding.dateOfBirth.getText().toString());
        contactViewModel.SaveContact(contactInfo);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}