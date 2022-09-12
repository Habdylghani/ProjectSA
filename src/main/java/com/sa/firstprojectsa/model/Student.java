package com.sa.firstprojectsa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Student {
    @Id
    private UUID id;
    private String first;
    private String last;
    private LocalDate dob;
    private double gpa;

//    public double getGpa() {
//        return gpa;
//    }
//
//    public void setGpa(double gpa) {
//        this.gpa = gpa;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getFirst() {
//        return first;
//    }
//
//    public void setFirst(String first) {
//        this.first = first;
//    }
//
//    public String getLast() {
//        return last;
//    }
//
//    public void setLast(String last) {
//        this.last = last;
//    }
//
//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }
}
