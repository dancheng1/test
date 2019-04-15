package com.dancheng.bs.university.model;

public class UniversityModel {

    private int id;

    private String schoolName;

    private String picLink;

    private String picClickLink;

    private String registrationTime;

    private String registrationConditionLink;

    public UniversityModel(){

    }

    public UniversityModel(UniversityFaceModel universityFaceModel){
        if(universityFaceModel != null){
            if(universityFaceModel.getId() != null)
                this.id = Integer.parseInt(universityFaceModel.getId());
            if(universityFaceModel.getSchoolName() != null)
                this.schoolName = universityFaceModel.getSchoolName();
            if(universityFaceModel.getPicLink() != null)
                this.picLink = universityFaceModel.getPicLink();
            if(universityFaceModel.getPicClickLink() != null)
                this.picClickLink = universityFaceModel.getPicClickLink();
            if(universityFaceModel.getRegistrationTime() != null)
                this.registrationTime = universityFaceModel.getRegistrationTime();
            if(universityFaceModel.getRegistrationConditionLink() != null)
                this.registrationConditionLink = universityFaceModel.getRegistrationConditionLink();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public String getPicClickLink() {
        return picClickLink;
    }

    public void setPicClickLink(String picClickLink) {
        this.picClickLink = picClickLink;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getRegistrationConditionLink() {
        return registrationConditionLink;
    }

    public void setRegistrationConditionLink(String registrationConditionLink) {
        this.registrationConditionLink = registrationConditionLink;
    }

    @Override
    public String toString() {
        return "UniversityModel{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", picLink='" + picLink + '\'' +
                ", picClickLink='" + picClickLink + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                ", registrationConditionLink='" + registrationConditionLink + '\'' +
                '}';
    }
}