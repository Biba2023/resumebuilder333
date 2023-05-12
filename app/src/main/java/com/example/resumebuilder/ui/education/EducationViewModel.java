package com.example.resumebuilder.ui.education;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.resumebuilder.data.ContactInfo;
import com.example.resumebuilder.data.Education;
import com.example.resumebuilder.db.RealmManager;

public class EducationViewModel extends ViewModel {
    private final MutableLiveData<Education> mEducationLiveData;
    private final Education mEducation;

    public EducationViewModel() {
        Education education = (Education) RealmManager.getInstance().getRealmObject(Education.class);
        if(education == null)
            mEducation = new Education();
        else
            mEducation = new Education(education);
        mEducationLiveData = new MutableLiveData<>(mEducation);
    }

    public LiveData<Education> getEducationLiveData() {
        return mEducationLiveData;
    }
    public void SaveEducation(Education education){

        mEducation.setUniversity(education.getUniversity());
        mEducation.setQualification(education.getQualification());
        mEducation.setGrade(education.getGrade());
        mEducation.setDetails(education.getDetails());
        mEducation.setStartDate(education.getStartDate());
        mEducation.setEndDate(education.getEndDate());
        mEducationLiveData.setValue(mEducation);
        RealmManager.getInstance().update(mEducation);
    }
}
