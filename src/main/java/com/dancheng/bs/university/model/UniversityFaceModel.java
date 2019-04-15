package com.dancheng.bs.university.model;

public class UniversityFaceModel {

    private String id;

    private String schoolName;  //大学名称

    private String picLink;   //校徽

    private String picClickLink;   //点击校徽显示此连接的pdf

    private String registrationTime;   //报名时间

    private String registrationConditionLink;  //报名条件

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "UniversityFaceModel{" +
                "id='" + id + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", picLink='" + picLink + '\'' +
                ", picClickLink='" + picClickLink + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                ", registrationConditionLink='" + registrationConditionLink + '\'' +
                '}';
    }
}