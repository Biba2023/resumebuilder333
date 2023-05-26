package com.example.resumebuilder.data;

import com.example.resumebuilder.App;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ContactInfo extends RealmObject {

    @PrimaryKey
    private int id = 1;
    private String name;
    private String email;
    private String telephone;
    private String address;
    private String dateOfBirth;
    public ContactInfo() {
        this.name = "";
        this.email = "";
        this.telephone = "";
        this.address = "";
        this.dateOfBirth = "";
    }
    public ContactInfo(ContactInfo contactInfo){
        this(contactInfo.getName(), contactInfo.getEmail(), contactInfo.getTelephone(), contactInfo.getAddress(), contactInfo.getDateOfBirth());
    }
    public ContactInfo(String name, String email, String telephone, String address, String dateOfBirth) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        App.nameResume = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        App.emailResume = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
        App.telephoneResume = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        App.addressResume = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        App.dateofBirthResume = dateOfBirth;
    }
    @Override
    public String toString() {
        return "ContactInfo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
