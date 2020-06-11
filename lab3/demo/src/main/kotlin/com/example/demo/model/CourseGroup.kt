package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name="course_group")
data class CourseGroup(
        @Id
        @JsonProperty("courseGroupId")
        @Column(name = "courseGroupId")
        @GeneratedValue(strategy = GenerationType.AUTO)
        var courseGroupId: Int? = null,
        @JsonProperty("lastUpdated")
        @Column(name = "lastUpdated")
        var lastUpdated : String = ""
)