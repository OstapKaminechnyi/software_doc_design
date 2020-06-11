package com.example.demo.service

import com.example.demo.model.CourseGroup
import com.example.demo.repository.CourseGroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseGroupServices {

    @Autowired
    lateinit var courseGroupRepository: CourseGroupRepository

    fun all(): Iterable<CourseGroup> = courseGroupRepository.findAll()

    fun get(id: Int): CourseGroup = courseGroupRepository.findOne(id)

    fun edit(id: Int, courseGroup: CourseGroup): CourseGroup = courseGroupRepository.save(courseGroup.copy(courseGroupId = id))

    fun remove(id: Int) = courseGroupRepository.delete(id)


    fun save(courseGroup: CourseGroup) {
        courseGroupRepository.save(courseGroup)
    }

    fun deleteAll() {
        courseGroupRepository.deleteAll()
    }
}