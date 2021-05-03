package com.example.demo.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "article")
data class Article(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0,
        val name: String,
        val short_description: String,
        val description: String,
        val create_dt: LocalDateTime,
        val modify_dt: LocalDateTime
)