package com.example.demo.repository

import com.example.demo.model.Institution
import org.springframework.data.repository.CrudRepository

interface InstitutionRepository  : CrudRepository<Institution, Int>