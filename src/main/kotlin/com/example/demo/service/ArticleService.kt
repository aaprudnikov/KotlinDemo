package com.example.demo.service

import com.example.demo.model.Article
import com.example.demo.request.InsertArticleRequest
import com.example.demo.request.UpdateArticleRequest

interface ArticleService {

    fun findAll(): List<Article>

    fun findById(id: Int): Article

    fun create(request: InsertArticleRequest)

    fun update(id: Int, request: UpdateArticleRequest)

    fun delete(id: Int)
}