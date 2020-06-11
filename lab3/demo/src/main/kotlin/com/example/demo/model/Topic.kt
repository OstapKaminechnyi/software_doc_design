package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "topic")
data class Topic(
        @Id
        @JsonProperty("topic_id")
        @Column(name = "topic_id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        var topic_id : Int? = null,
        @JsonProperty("title")
        @Column(name = "title")
        var title: String = "",
        @JsonProperty("sessionNumber")
        @Column(name = "sessionNumber")
        var sessionNumber : Int? = null,
        @JsonProperty("lastUpdated")
        @Column(name = "lastUpdated")
        var lastUpdated : Int? = null
)