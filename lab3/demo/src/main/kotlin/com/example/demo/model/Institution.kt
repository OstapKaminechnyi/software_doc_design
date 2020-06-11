package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name ="institution")
data class Institution(
        @Id
        @JsonProperty("institution_id")
        @Column(name = "institution_id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        var institution_id: Int? = null,
        @JsonProperty("name")
        @Column(name = "name")
        var name: String = ""
)