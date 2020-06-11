package com.crudapp.repository;

import com.crudapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByNameContaining
    (String search);

    Course findByCourseId(int courseId);

}
