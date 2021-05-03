package com.example.demo.request

import java.security.Timestamp
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class InsertArticleRequest (

        @get:NotNull
        @get:Size(min = 1, max = 20)
        val name: String?,

        @get:NotNull
        @get:Size(min = 1, max = 30)
        val short_description: String?,

        @get:NotNull
        @get:Size(min = 1, max = 50)
        val description: String?,

        val create_dt: LocalDateTime = LocalDateTime.now(),

        val modify_dt: LocalDateTime = LocalDateTime.now()
)

data class UpdateArticleRequest (

        @get:NotNull
        @get:Size(min = 1, max = 20)
        val name: String?,

        @get:NotNull
        @get:Size(min = 1, max = 30)
        val short_description: String?,

        @get:NotNull
        @get:Size(min = 1, max = 50)
        val description: String?,

        val modify_dt: LocalDateTime = LocalDateTime.now()
)