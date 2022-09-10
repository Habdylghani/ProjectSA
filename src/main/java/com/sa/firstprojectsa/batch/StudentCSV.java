package com.sa.firstprojectsa.batch;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

public class StudentCSV {
    @Id
    private UUID id;
    private String first;
    private String last;
    private double gpa;
    private int age;

    public double getGpa() {
        return gpa;
    }

    public UUID getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public int getAge() {
        return age;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
