package com.example.week4assignment3;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    Integer age;
    Integer moodValue;
    Integer moodImageValue;


    public User(){

    }
    public User(String name, Integer age, Integer moodValue, Integer moodImageValue) {
        this.name = name;
        this.age = age;
        this.moodValue = moodValue;
        this.moodImageValue = moodImageValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMoodValue() {
        return moodValue;
    }

    public void setMoodValue(Integer moodValue) {
        this.moodValue = moodValue;
    }

    public Integer getMoodImageValue() {
        return moodImageValue;
    }

    public void setMoodImageValue(Integer moodImageValue) {
        this.moodImageValue = moodImageValue;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", moodValue=" + moodValue +
                ", moodImageValue=" + moodImageValue +
                '}';
    }
}