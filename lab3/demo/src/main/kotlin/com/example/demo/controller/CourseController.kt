package com.example.demo.controller

import com.example.demo.model.Course
import com.example.demo.service.CourseServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("course")
class CourseController (private val courseServices: CourseServices){
    @GetMapping
    fun index() = courseServices.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody course: Course) = courseServices.save(course)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id : Int) = courseServices.get(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Int, @RequestBody course: Course) = courseServices.edit(id, course)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) = courseServices.remove(id)
}