package com.example;


import java.util.List;

public class Student {
    String id;
    String name;
    String description;
    List<Course> course;


    public Student(String id, String name, String description, List<Course> courses){
        this.id = id;
        this.name = name;
        this.description = description;
        this.course = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}
