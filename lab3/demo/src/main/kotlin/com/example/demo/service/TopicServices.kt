package com.example.demo.service

import com.example.demo.model.Topic
import com.example.demo.repository.TopicRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TopicServices {
    @Autowired
    lateinit var topicRepository: TopicRepository

    fun all(): Iterable<Topic> = topicRepository.findAll()

    fun get(id: Int): Topic = topicRepository.findOne(id)

    fun edit(id: Int, Topic: Topic): Topic = topicRepository.save(Topic.copy(topic_id = id))

    fun remove(id: Int) = topicRepository.delete(id)

    fun save(topic: Topic){
        topicRepository.save(topic)
    }

    fun deleteAll(){
        topicRepository.deleteAll()
    }
}