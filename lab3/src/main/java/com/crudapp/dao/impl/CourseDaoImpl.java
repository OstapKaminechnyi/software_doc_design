package com.crudapp.dao.impl;

import com.crudapp.dao.CourseDao;
import com.crudapp.entity.Course;
import com.crudapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class CourseDaoImpl  implements CourseDao {
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) throws Exception {
        Course courseObj=null;
        try {
//			CourseObj = CourseRepository.findByCourseId(Course.getCourseId());
            courseObj = courseRepository.save(course);
        } catch (Exception e) {
        }
        return courseObj;
    }

    @Override
    public List<Course> getCourses() throws Exception {
        List<Course> courseObj=null;
        try {
            courseObj = courseRepository.findAll();
        } catch (Exception e) {
        }
        return courseObj;
    }

    @Override
    public List<Course> getCourse(String search) throws Exception {
        List<Course> courseObj=null;
        try {
            courseObj = courseRepository.findByNameContaining(search);
        } catch (Exception e) {
        }
        return courseObj;
    }

    @Override
    public void deleteCourse(int courseId) throws Exception {
        try {
            courseRepository.delete(courseId);
        } catch (Exception e) {
        }
    }

    @Override
    public Course editCourse(int courseId) throws Exception {
        Course courseObj=null;
        try {
            courseObj=courseRepository.findByCourseId(courseId);
        } catch (Exception e) {
        }
        return courseObj;
    }
}
