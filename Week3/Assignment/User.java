package com.example.week3assignment2;

/*
    a. Assignment #.            : 2
    b. File Name.               : Assignment2.zip
    c. Full name of the student : NeerajKumar Badam(801369013), Varun Tadepalli(801365164)
*/

import java.io.Serializable;

public class User implements Serializable {
    String name;
    Integer age;
    Integer moodValue;


    public User(){

    }
    public User(String name, Integer age, Integer moodValue) {
        this.name = name;
        this.age = age;
        this.moodValue = moodValue;
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
}
