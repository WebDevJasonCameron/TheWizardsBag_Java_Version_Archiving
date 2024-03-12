package com.gui.javaFXTest;

import javafx.beans.property.DoubleProperty;

public class EmploymentRequest {

    // ATTs
    private final String name;
    private final String position;
    private final Double annualSalary;

    // CONs
    public EmploymentRequest(String name, String position, Double annualSalary) {
        this.name = name;
        this.position = position;
        this.annualSalary = annualSalary;
    }

    // GETs
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    // OVRs
    @Override
    public String toString() {
        return "EmploymentRequest{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", annualSalary=" + annualSalary +
                '}';
    }
}
