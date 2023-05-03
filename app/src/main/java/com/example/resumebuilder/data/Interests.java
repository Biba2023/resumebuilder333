package com.example.resumebuilder.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Interests extends RealmObject {
    @PrimaryKey
    private int id = 1;
    private String interests;
    public Interests(){
        this.interests = "";
    }
    public Interests(String interests){
        this.interests = interests;
    }
    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}

