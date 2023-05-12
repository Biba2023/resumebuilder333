package com.example.resumebuilder.ui.keySkills;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.resumebuilder.data.ContactInfo;
import com.example.resumebuilder.data.KeySkills;
import com.example.resumebuilder.data.KeySkills;
import com.example.resumebuilder.data.PersonalInfo;
import com.example.resumebuilder.db.RealmManager;

public class KeySkillsViewModel extends ViewModel {
    private final MutableLiveData<KeySkills> mKeySkillsLiveData;
    private final KeySkills mKeySkills;

    public KeySkillsViewModel() {
        KeySkills keySkills = (KeySkills) RealmManager.getInstance().getRealmObject(KeySkills.class);
        if(keySkills == null)
            mKeySkills = new KeySkills();
        else
            mKeySkills = new KeySkills(keySkills);
        mKeySkillsLiveData = new MutableLiveData<>(mKeySkills);
    }

    public LiveData<KeySkills> getKeySkillsLiveData() {
        return mKeySkillsLiveData;
    }
    public void SaveKeySkills(KeySkills keySkills){

        mKeySkills.setKeySkills(keySkills.getKeySkills());
        mKeySkillsLiveData.setValue(mKeySkills);
        RealmManager.getInstance().update(mKeySkills);
    }
}
