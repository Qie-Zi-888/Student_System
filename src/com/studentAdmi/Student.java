package com.studentAdmi;

import java.util.ArrayList;
import java.util.Objects;

public class Student {
    //姓名
    private String name;
    //性别
    private String sex;
    //籍贯
    private String place;
    //学号
    private String code;
    //系别
    private String dept;
    //班级
    private String ban;

    public Student(){}

    public Student(String name, String sex, String place, String code, String dept, String ban){
        this.name = name;
        this.sex = sex;
        this.place = place;
        this.code = code;
        this.dept = dept;
        this.ban = ban;
    }

    //姓名
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //性别
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    //籍贯
    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    //学号
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    //系别
    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDept() {
        return dept;
    }

    //班别
    public void setBan(String ban) {
        this.ban = ban;
    }

    public String getBan() {
        return ban;
    }
    
    @Override
    public String toString() {
    	return "    " + this.name + "    " + this.sex + "    " + this.place + "    " + this.code + "    " + this.dept + "    " + this.ban ;
    }
}
