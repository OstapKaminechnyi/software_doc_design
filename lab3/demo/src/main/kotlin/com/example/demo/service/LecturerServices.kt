package com.example.demo.service

import com.example.demo.model.Lecturer
import com.example.demo.repository.LecturerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LecturerServices {

    @Autowired
    lateinit var lecturerRepository: LecturerRepository

    fun all(): Iterable<Lecturer> = lecturerRepository.findAll()

    fun get(id: Int): Lecturer = lecturerRepository.findOne(id)

    fun edit(id: Int, Lecturer: Lecturer): Lecturer = lecturerRepository.save(Lecturer.copy(lecturerId = id))

    fun remove(id: Int) = lecturerRepository.delete(id)

    fun save(lecturer: Lecturer){
        lecturerRepository.save(lecturer)
    }

    fun deleteAll(){
        lecturerRepository.deleteAll()
    }
}