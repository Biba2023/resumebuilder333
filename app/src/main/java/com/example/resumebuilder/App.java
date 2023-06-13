package com.example.resumebuilder;

import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;

import com.example.resumebuilder.data.Career;
import com.example.resumebuilder.data.ContactInfo;
import com.example.resumebuilder.data.Education;
import com.example.resumebuilder.data.Interests;
import com.example.resumebuilder.data.KeySkills;
import com.example.resumebuilder.data.PersonalInfo;
import com.example.resumebuilder.data.Photo;
import com.example.resumebuilder.data.Projects;
import com.example.resumebuilder.db.RealmManager;

import io.realm.Realm;

public class App extends Application {
    public static String nameResume = "ФИО";
    public static String emailResume = "email";
    public static String telephoneResume = "телефон";
    public static String addressResume = "Адрес";
    public static String dateofBirthResume = "";
    public static String experienceResume = "Ключевой опыт";
    public static String nameOfCompanyResume = "Название компании";
    public static String jobResume = "Должность";
    public static String introductionResume = "Основные обязанности";
    public static String detailsOfJobResume = "Детали";
    public static String startDateJobResume = "";
    public static String endDateJobResume = "";
    public static String universityResume = "Название школы/университета";
    public static String qualificationResume = "Квалификация";
    public static String gradeResume = "Средняя оценка";
    public static String detailsOfEduResume = "Детали";
    public static String startDateOfEduResume = "";
    public static String endDateOfEduResume = "";
    public static String projectResume = "Название проекта";
    public static String detailsOfProjectResume = "Детали";
    public static String startDateOfProjectResume = "";
    public static String endDateOfProjectResume = "";
    public static String keySkillsResume = "Ключевые навыки";
    public static String interestsResume = "Интересы";

    public static Bitmap photoResume;
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        ContactInfo contactInfo = (ContactInfo) RealmManager.getInstance().getRealmObject(ContactInfo.class);
        Realm.init(this);
        PersonalInfo personalInfo = (PersonalInfo) RealmManager.getInstance().getRealmObject(PersonalInfo.class);
        Career career = (Career) RealmManager.getInstance().getRealmObject(Career.class);
        Education education = (Education) RealmManager.getInstance().getRealmObject(Education.class);
        Projects projects = (Projects) RealmManager.getInstance().getRealmObject(Projects.class);
        KeySkills keySkills = (KeySkills) RealmManager.getInstance().getRealmObject(KeySkills.class);
        Interests interests = (Interests) RealmManager.getInstance().getRealmObject(Interests.class);
        //Photo photo = (Photo) RealmManager.getInstance().getRealmObject(Photo.class);
        nameResume = contactInfo.getName();
        addressResume = contactInfo.getAddress();
        emailResume = contactInfo.getEmail();
        telephoneResume = contactInfo.getTelephone();
        dateofBirthResume = contactInfo.getDateOfBirth();
        experienceResume = personalInfo.getKeyExperience();
        jobResume = career.getJob();
        introductionResume = career.getIntroduction();
        detailsOfJobResume = career.getDetails();
        startDateJobResume = career.getStartDate();
        endDateJobResume = career.getEndDate();
        universityResume = education.getUniversity();
        qualificationResume = education.getQualification();
        gradeResume = education.getGrade();
        detailsOfEduResume = education.getDetails();
        startDateOfEduResume = education.getStartDate();
        endDateOfEduResume = education.getEndDate();
        projectResume = projects.getProject();
        detailsOfProjectResume = projects.getDetails();
        startDateOfProjectResume = projects.getStartDate();
        endDateOfProjectResume = projects.getEndDate();
        keySkillsResume = keySkills.getKeySkills();
        interestsResume = interests.getInterests();
        //photoPathResume = photo.getPhotoPath();


    }



}

