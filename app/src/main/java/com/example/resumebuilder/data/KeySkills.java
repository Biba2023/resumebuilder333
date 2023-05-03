package com.example.resumebuilder.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class KeySkills extends RealmObject {
    @PrimaryKey
    private int id = 1;
    private String keySkills;
    public KeySkills(){
        this.keySkills = "";
    }
    public KeySkills(String keySkills){
        this.keySkills = keySkills;
    }
    public String getKeySkills() {
        return keySkills;
    }

    public void setKeySkills(String keySkills) {
        this.keySkills = keySkills;
    }
}
