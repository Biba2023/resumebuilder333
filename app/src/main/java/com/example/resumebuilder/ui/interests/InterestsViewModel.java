package com.example.resumebuilder.ui.interests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.resumebuilder.data.ContactInfo;
import com.example.resumebuilder.data.Interests;
import com.example.resumebuilder.data.PersonalInfo;
import com.example.resumebuilder.db.RealmManager;

public class InterestsViewModel extends ViewModel {
    private final MutableLiveData<Interests> mInterestsLiveData;
    private final Interests mInterests;

    public InterestsViewModel() {
        Interests interests = (Interests) RealmManager.getInstance().getRealmObject(Interests.class);
        if(interests == null)
            mInterests = new Interests();
        else
            mInterests = new Interests(interests);
        mInterestsLiveData = new MutableLiveData<>(mInterests);
    }

    public LiveData<Interests> getInterestsLiveData() {
        return mInterestsLiveData;
    }
    public void SaveInterests(Interests interests){

        mInterests.setInterests(interests.getInterests());
        mInterestsLiveData.setValue(mInterests);
        RealmManager.getInstance().update(mInterests);
    }
}
