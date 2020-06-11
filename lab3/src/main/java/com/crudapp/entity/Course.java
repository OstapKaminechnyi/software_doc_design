package com.crudapp.entity;


import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "name")
    private String name;

    @Column(name = "lastUpdated")
    private String lastUpdated;

    @Column(name = "length")
    private String length;

    @Column(name = "effort")
    private String effort;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getEffort() {
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }
}

