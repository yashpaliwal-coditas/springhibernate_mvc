package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {
    @Id
    private int studentId;
    private String name;
    private String city;

    public Students() {
    }

    public Students(int studentId, String name, String city) {
        this.studentId = studentId;
        this.name = name;
        this.city = city;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
