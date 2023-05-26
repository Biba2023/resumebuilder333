package com.example.resumebuilder.data;

import com.example.resumebuilder.App;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Interests extends RealmObject {
    @PrimaryKey
    private int id = 1;
    private String interests;
    public Interests(){
        this.interests = "";
    }
    public Interests(Interests interests){
        this(interests.getInterests());
    }
    public Interests(String interests){
        this.interests = interests;
    }
    public int getId() {
        return id;
    }
    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
        App.interestsResume = interests;
    }
    @Override
    public String toString() {
        return "Interests{" +
                "interests='" + interests + '\'' +
                '}';
    }
}

