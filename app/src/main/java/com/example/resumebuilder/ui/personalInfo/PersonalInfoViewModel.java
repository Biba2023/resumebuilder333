package com.example.resumebuilder.ui.personalInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.resumebuilder.data.ContactInfo;
import com.example.resumebuilder.data.PersonalInfo;
import com.example.resumebuilder.db.RealmManager;

public class PersonalInfoViewModel extends ViewModel {

    private final MutableLiveData<PersonalInfo> mPersonalInfoLiveData;
    private final PersonalInfo mPersonalInfo;

    public PersonalInfoViewModel() {
        PersonalInfo personalInfo = (PersonalInfo) RealmManager.getInstance().getRealmObject(PersonalInfo.class);
        if(personalInfo == null)
            mPersonalInfo = new PersonalInfo();
        else
            mPersonalInfo = new PersonalInfo(personalInfo);
        mPersonalInfoLiveData = new MutableLiveData<>(mPersonalInfo);
    }

    public LiveData<PersonalInfo> getPersonalInfoLiveData() {
        return mPersonalInfoLiveData;
    }
    public void SavePersonalInfo(PersonalInfo personalInfo){

        mPersonalInfo.setKeyExperience(personalInfo.getKeyExperience());
        mPersonalInfoLiveData.setValue(mPersonalInfo);
        RealmManager.getInstance().update(mPersonalInfo);
    }
}