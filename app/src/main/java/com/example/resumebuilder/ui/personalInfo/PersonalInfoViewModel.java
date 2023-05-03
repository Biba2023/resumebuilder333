package com.example.resumebuilder.ui.personalInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.resumebuilder.data.PersonalInfo;

public class PersonalInfoViewModel extends ViewModel {

    private final MutableLiveData<PersonalInfo> mPersonalInfoLiveData;
    private final PersonalInfo mPersonalInfo;

    public PersonalInfoViewModel() {
        mPersonalInfo = new PersonalInfo();
        mPersonalInfoLiveData = new MutableLiveData<>(mPersonalInfo);
    }

    public LiveData<PersonalInfo> getPersonalInfoLiveData() {
        return mPersonalInfoLiveData;
    }
    public void SavePersonalInfo(PersonalInfo personalInfo){

        mPersonalInfo.setKeyExperience(personalInfo.getKeyExperience());
        mPersonalInfoLiveData.setValue(mPersonalInfo);
    }
}