package com.example.resumebuilder.ui.contact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.resumebuilder.data.ContactInfo;
import com.example.resumebuilder.db.RealmManager;

public class ContactViewModel extends ViewModel {

    private final MutableLiveData<ContactInfo> mContactInfoLiveData;
    private final ContactInfo mContactInfo;

    public ContactViewModel() {


        ContactInfo contactInfo = (ContactInfo) RealmManager.getInstance().getRealmObject(ContactInfo.class);
        if(contactInfo == null)
            mContactInfo = new ContactInfo();
        else
            mContactInfo = new ContactInfo(contactInfo);

        mContactInfoLiveData = new MutableLiveData<>(mContactInfo);
    }

    public LiveData<ContactInfo> getContactInfoLiveData() {
        return mContactInfoLiveData;
    }
    public void SaveContact(ContactInfo contactInfo){

        mContactInfo.setAddress(contactInfo.getAddress());
        mContactInfo.setName(contactInfo.getName());
        mContactInfo.setEmail(contactInfo.getEmail());
        mContactInfo.setTelephone(contactInfo.getTelephone());
        mContactInfo.setDateOfBirth(contactInfo.getDateOfBirth());

        mContactInfoLiveData.setValue(mContactInfo);

        RealmManager.getInstance().update(mContactInfo);
    }
}