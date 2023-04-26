package com.example.resumebuilder.data;

public class PersonalInfo {
    private String keyExperience;
    public PersonalInfo(){
        this.keyExperience = "";
    }
    public PersonalInfo(String keyExperience){
        this.keyExperience = keyExperience;
    }
    public String getKeyExperience() {
        return keyExperience;
    }

    public void setKeyExperience(String keyExperience) {
        this.keyExperience = keyExperience;
    }
}
