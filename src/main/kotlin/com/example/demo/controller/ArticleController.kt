package com.example.demo.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.demo.model.Article
import com.example.demo.request.InsertArticleRequest
import com.example.demo.request.UpdateArticleRequest
import com.example.demo.response.StatusResponse
import com.example.demo.service.ArticleService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import javax.validation.Valid

@RestController
@RequestMapping("/articles", produces = [MediaType.APPLICATION_JSON_VALUE])
@Api(description = "Сервис работы со статьями")
class ArticleController(private val articleService: ArticleService) {

    @GetMapping
    @ApiOperation("Получить список всех статей")
    fun findAll() = articleService.findAll()

    @ApiOperation("Получить статью по ее ID")
    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Int): Article {
        return articleService.findById(id)
    }

    @ApiOperation("Добавить новую статью")
    @PostMapping
    fun create(@Valid @RequestBody request: InsertArticleRequest): StatusResponse {
        articleService.create(request)
        return StatusResponse("Created")
    }

    @ApiOperation("Изменить ранее добавленную статью")
    @PutMapping("/{id}")
    fun update(
            @PathVariable("id") id: Int,
            @Valid @RequestBody request: UpdateArticleRequest): StatusResponse {
        articleService.update(id, request)
        return StatusResponse("Updated")
    }

    @ApiOperation("Удалить статью")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int
    ): StatusResponse {
        articleService.delete(id)
        return StatusResponse("Deleted")
    }
}