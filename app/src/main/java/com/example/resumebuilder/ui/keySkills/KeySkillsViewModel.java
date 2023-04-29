package com.example.resumebuilder.ui.keySkills;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.resumebuilder.data.KeySkills;
import com.example.resumebuilder.data.KeySkills;
import com.example.resumebuilder.data.PersonalInfo;

public class KeySkillsViewModel extends ViewModel {
    private final MutableLiveData<KeySkills> mKeySkillsLiveData;
    private final KeySkills mKeySkills;

    public KeySkillsViewModel() {
        mKeySkills = new KeySkills();
        mKeySkillsLiveData = new MutableLiveData<>(mKeySkills);
    }

    public LiveData<KeySkills> getKeySkillsLiveData() {
        return mKeySkillsLiveData;
    }
    public void SaveKeySkills(KeySkills keySkills){

        mKeySkills.setKeySkills(keySkills.getKeySkills());
        mKeySkillsLiveData.setValue(mKeySkills);
    }
}
