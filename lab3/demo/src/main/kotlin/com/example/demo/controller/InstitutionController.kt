package com.example.demo.controller

import com.example.demo.model.Institution
import com.example.demo.service.InstitutionServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("institution")
class InstitutionController(private val institutionServices: InstitutionServices) {

    @GetMapping
    fun index() = institutionServices.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody institution: Institution) = institutionServices.save(institution)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: Int) = institutionServices.get(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Int, @RequestBody institution: Institution) = institutionServices.edit(id, institution)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) = institutionServices.remove(id)
}