package com.example.demo.controller

import com.example.demo.model.Lecturer
import com.example.demo.service.LecturerServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("lecturer")
class LecturerController(private val lecturerServices: LecturerServices) {

    @GetMapping
    fun index() = lecturerServices.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody lecturer: Lecturer) = lecturerServices.save(lecturer)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: Int) = lecturerServices.get(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Int, @RequestBody lecturer: Lecturer) = lecturerServices.edit(id, lecturer)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) = lecturerServices.remove(id)
}