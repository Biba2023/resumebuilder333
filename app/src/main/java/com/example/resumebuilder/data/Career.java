package com.example.resumebuilder.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Career extends RealmObject {
    @PrimaryKey
    private int id = 1;
    private String nameofCompany;
    private String job;
    private String introduction;
    private String details;
    private String startDate;
    private String endDate;

    public Career() {
        this.nameofCompany = "";
        this.job = "";
        this.introduction = "";
        this.details = "";
        this.startDate = "";
        this.endDate = "";
    }

    public Career(String nameofCompany, String job, String introduction, String details, String startDate, String endDate) {
        this.nameofCompany = nameofCompany;
        this.job = job;
        this.introduction = introduction;
        this.details = details;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getNameofCompany() {
        return nameofCompany;
    }

    public void setNameofCompany(String nameofCompany) {
        this.nameofCompany = nameofCompany;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

