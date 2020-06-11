package com.example.demo.service

import com.example.demo.model.Institution
import com.example.demo.repository.InstitutionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InstitutionServices {

    @Autowired
    lateinit var institutionRepository: InstitutionRepository

    fun all(): Iterable<Institution> = institutionRepository.findAll()

    fun get(id: Int): Institution = institutionRepository.findOne(id)

    fun edit(id: Int, institution: Institution): Institution = institutionRepository.save(institution.copy(institution_id = id))

    fun remove(id: Int) = institutionRepository.delete(id)

    fun save(institution: Institution){
        institutionRepository.save(institution)
    }

    fun deleteAll(){
        institutionRepository.deleteAll()
    }
}