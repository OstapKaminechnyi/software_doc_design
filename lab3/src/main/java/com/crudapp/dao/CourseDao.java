package com.crudapp.dao;

import com.crudapp.entity.Course;

import java.util.List;

public interface CourseDao {

    public Course addCourse(Course course) throws Exception;

    public List<Course> getCourses() throws Exception;

    public List<Course> getCourse(String search) throws Exception;

    public void deleteCourse(int courseId) throws Exception;

    public Course editCourse(int courseId) throws Exception;
}
