package com.example.resumebuilder.ui.education;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.resumebuilder.data.Education;

public class EducationViewModel extends ViewModel {
    private final MutableLiveData<Education> mEducationLiveData;
    private final Education mEducation;

    public EducationViewModel() {
        mEducation = new Education();
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
    }
}
