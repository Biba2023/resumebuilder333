package com.example.resumebuilder.data;

import com.example.resumebuilder.App;

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
    public Career(Career career){
        this(career.getNameofCompany(), career.getJob(), career.getIntroduction(), career.getDetails(), career.getStartDate(), career.getEndDate());
    }

    public Career(String nameofCompany, String job, String introduction, String details, String startDate, String endDate) {
        this.nameofCompany = nameofCompany;
        this.job = job;
        this.introduction = introduction;
        this.details = details;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public int getId() {
        return id;
    }
    public String getNameofCompany() {
        return nameofCompany;
    }

    public void setNameofCompany(String nameofCompany) {
        this.nameofCompany = nameofCompany;
        App.nameOfCompanyResume = nameofCompany;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
        App.jobResume = job;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
        App.introductionResume = introduction;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
        App.detailsOfJobResume = details;
    }

    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
        App.startDateJobResume = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
        App.endDateJobResume = endDate;
    }
    @Override
    public String toString() {
        return "Career{" +
                "nameofCompany='" + nameofCompany + '\'' +
                ", job='" + job + '\'' +
                ", introduction='" + introduction + '\'' +
                ", details='" + details + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

