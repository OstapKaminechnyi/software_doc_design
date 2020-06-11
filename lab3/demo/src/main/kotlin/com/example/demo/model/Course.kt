package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class Course (
        @Id
        @JsonProperty("courseId")
        @Column(name = "courseId")
        @GeneratedValue(strategy = GenerationType.AUTO)
        var courseId: Int? = null,
        @JsonProperty("name")
        @Column(name = "name", length = 1000)
        var name: String = "",
        @JsonProperty("lastUpdated")
        @Column(name = "lastUpdated", length = 1000)
        var lastUpdated: String = "",
        @JsonProperty("length")
        @Column(name = "length", length = 1000)
        var length: String = "",
        @JsonProperty("effort")
        @Column(name = "effort", length = 1000)
        var effort: String = ""
)


