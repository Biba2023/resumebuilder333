package com.example.resumebuilder.data;

public class Education {
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

    public Education(String university, String qualification, String grade, String details, String startDate, String endDate) {
        this.university = university;
        this.qualification = qualification;
        this.grade = grade;
        this.details = details;
        this.startDate = startDate;
        this.endDate = endDate;
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
}

