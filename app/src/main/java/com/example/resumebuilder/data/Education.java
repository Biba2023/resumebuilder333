package com.example.resumebuilder.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Education  extends RealmObject {
    @PrimaryKey
    private int id = 1;
    private String university;
    private String qualification;
    private String grade;
    private String details;
    private String startDate;
    private String endDate;

    public Education() {
        this.university = "";
        this.qualification = "";
        this.grade= "";
        this.details = "";
        this.startDate = "";
        this.endDate = "";
    }
    public Education(Education education){
        this(education.getUniversity(), education.getQualification(), education.getGrade(),education.getDetails(), education.getStartDate(), education.getEndDate());
    }

    public Education(String university, String qualification, String grade, String details, String startDate, String endDate) {
        this.university = university;
        this.qualification = qualification;
        this.grade = grade;
        this.details = details;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public int getId() {
        return id;
    }
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    @Override
    public String toString() {
        return "Education{" +
                "university='" + university + '\'' +
                ", qualification='" + qualification + '\'' +
                ", grade='" + grade + '\'' +
                ", details='" + details + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

