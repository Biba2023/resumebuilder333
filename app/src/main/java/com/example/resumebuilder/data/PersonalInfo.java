package com.example.resumebuilder.data;

import com.example.resumebuilder.App;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PersonalInfo extends RealmObject {
    @PrimaryKey
    private int id = 1;
    private String keyExperience;
    public PersonalInfo(){
        this.keyExperience = "";
    }
    public PersonalInfo(PersonalInfo personalInfo){
        this(personalInfo.getKeyExperience());
    }
    public PersonalInfo(String keyExperience){
        this.keyExperience = keyExperience;
    }
    public String getKeyExperience() {
        return keyExperience;
    }

    public void setKeyExperience(String keyExperience) {
        this.keyExperience = keyExperience;
        App.experienceResume = keyExperience;
    }
    @Override
    public String toString() {
        return "PersonalInfo{" +
                ", keyExperience='" + keyExperience + '\'' +
                '}';
    }

}
