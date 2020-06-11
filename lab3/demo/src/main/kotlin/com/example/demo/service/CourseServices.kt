package com.example.demo.service

import com.example.demo.model.Course
import com.example.demo.repository.CourseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseServices {

    @Autowired
    lateinit var courseRepository: CourseRepository

    fun all(): Iterable<Course> = courseRepository.findAll()

    fun get(id: Int): Course = courseRepository.findOne(id)

    fun edit(id: Int, Course: Course): Course = courseRepository.save(Course.copy(courseId = id))

    fun remove(id: Int) = courseRepository.delete(id)

    fun save(course: Course){

        courseRepository.save(course)
    }

    fun deleteAll(){
        courseRepository.deleteAll()
    }
}