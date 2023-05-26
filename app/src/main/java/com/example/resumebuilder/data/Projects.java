package com.example.resumebuilder.data;

import com.example.resumebuilder.App;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Projects extends RealmObject {
    @PrimaryKey
    private int id = 1;
    private String project;
    private String details;
    private String startDate;
    private String endDate;

    public Projects() {
        this.project = "";
        this.details = "";
        this.startDate = "";
        this.endDate = "";
    }
    public Projects(Projects projects){
        this(projects.getProject(), projects.getDetails(), projects.getStartDate(), projects.getEndDate());
    }
    public Projects(String project, String details, String startDate, String endDate) {
        this.project = project;
        this.details = details;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
        App.projectResume = project;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
        App.detailsOfProjectResume = details;
    }

    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
        App.startDateOfProjectResume = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
        App.endDateOfProjectResume = endDate;
    }
    @Override
    public String toString() {
        return "Projects{" +
                "project='" + project + '\'' +
                ", details='" + details + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
