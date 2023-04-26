package com.example.resumebuilder.ui.career;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.resumebuilder.data.Career;

public class CareerViewModel extends ViewModel {

    private final MutableLiveData<Career> mCareerLiveData;
    private final Career mCareer;

    public CareerViewModel() {
        mCareer = new Career();
        mCareerLiveData = new MutableLiveData<>(mCareer);
    }

    public LiveData<Career> getCareerLiveData() {
        return mCareerLiveData;
    }
    public void SaveCareer(Career career){

        mCareer.setNameofCompany(career.getNameofCompany());
        mCareer.setJob(career.getJob());
        mCareer.setIntroduction(career.getIntroduction());
        mCareer.setDetails(career.getDetails());
        mCareer.setStartDate(career.getStartDate());
        mCareer.setEndDate(career.getEndDate());
        mCareerLiveData.setValue(mCareer);
    }
}
