package com.example.demo.controller

import com.example.demo.model.Topic
import com.example.demo.service.TopicServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("topic")
class TopicController (private val topicServices: TopicServices){

    @GetMapping
    fun index() = topicServices.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody topic: Topic) = topicServices.save(topic)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: Int) = topicServices.get(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Int, @RequestBody topic: Topic) = topicServices.edit(id, topic)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) = topicServices.remove(id)
}