package com.example.demo.repository

import com.example.demo.model.Lecturer
import org.springframework.data.repository.CrudRepository

interface LecturerRepository : CrudRepository<Lecturer, Int>