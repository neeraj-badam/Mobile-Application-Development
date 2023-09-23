package com.example.week4fragments;

import java.io.Serializable;

public class Calculation implements Serializable {

    String numberA, numberB, operation;

    public Calculation() {
    }

    public Calculation(String numberA, String numberB, String operation) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.operation = operation;
    }

    public String getNumberA () {
        return numberA;
    }

    public void setNumberA (String numberA){
        this.numberA = numberA;
    }

    public String getNumberB () {
        return numberB;
    }
    public void setNumberB (String numberB){
        this.numberB = numberB;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "numberA='" + numberA + '\'' +
                ", numberB='" + numberB + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}