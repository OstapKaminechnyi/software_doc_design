package com.example.demo.controller

import com.example.demo.model.CourseGroup
import com.example.demo.service.CourseGroupServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("course_group")
class CourseGroupController(private val courseGroupServices: CourseGroupServices) {
    @GetMapping
    fun index() = courseGroupServices.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody courseGroup: CourseGroup) = courseGroupServices.save(courseGroup)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: Int) = courseGroupServices.get(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Int, @RequestBody courseGroup: CourseGroup) = courseGroupServices.edit(id, courseGroup)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) = courseGroupServices.remove(id)
}