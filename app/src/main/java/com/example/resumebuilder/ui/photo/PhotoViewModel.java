package com.example.resumebuilder.ui.photo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.resumebuilder.data.PersonalInfo;
import com.example.resumebuilder.data.Photo;
import com.example.resumebuilder.db.RealmManager;

public class PhotoViewModel extends ViewModel {

    /*private final MutableLiveData<Photo> mPhotoLiveData;
    private final Photo mPhoto;

    public PhotoViewModel() {
        Photo photo = (Photo) RealmManager.getInstance().getRealmObject(Photo.class);
        if (photo == null)
            mPhoto = new Photo();
        else
            mPhoto = new Photo(photo);
        mPhotoLiveData = new MutableLiveData<>(mPhoto);
    }

    public LiveData<Photo> getPhotoLiveData() {
        return mPhotoLiveData;
    }

    public void SavePhoto(Photo photo) {

        mPhoto.setPhotoPath(photo.getPhotoPath());
        mPhotoLiveData.setValue(mPhoto);
        RealmManager.getInstance().update(mPhoto);
    }*/
}