package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name="lecturer")
data class Lecturer(
        @Id
        @JsonProperty("lecturerId")
        @Column(name = "lecturerId")
        @GeneratedValue(strategy = GenerationType.AUTO)
        var lecturerId : Int? = null,
        @JsonProperty("lecturerName")
        @Column(name = "lecturerName")
        var lecturerName: String = ""
)