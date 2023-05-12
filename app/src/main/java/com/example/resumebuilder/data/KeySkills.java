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
    public KeySkills(KeySkills keySkills){
        this(keySkills.getKeySkills());
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
    @Override
    public String toString() {
        return "KeySkills{" +
                "keySkills='" + keySkills + '\'' +
                '}';
    }
}
