package com.example.demo.repository

import com.example.demo.model.CourseGroup
import org.springframework.data.repository.CrudRepository

interface CourseGroupRepository  : CrudRepository<CourseGroup, Int>