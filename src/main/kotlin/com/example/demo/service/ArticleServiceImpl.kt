package com.example.demo.service

import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Service
import com.example.demo.dao.ArticleDao
import com.example.demo.exception.ArticleNotFoundException
import com.example.demo.model.Article
import com.example.demo.request.InsertArticleRequest
import com.example.demo.request.UpdateArticleRequest
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*

@Service
class ArticleServiceImpl(private val ArticleDao: ArticleDao) : ArticleService {

    override fun findAll(): List<Article> {
        log.info("Find all articles")
        return ArticleDao.findByOrderByName()
    }

    override fun findById(id: Int): Article {
        log.info("Find article with id=$id")
        return ArticleDao.findByIdOrNull(id) ?: throw ArticleNotFoundException(id)
    }

    override fun create(request: InsertArticleRequest) {
        log.info("Create new article with name=${request.name}")
        ArticleDao.save(
            Article(
                name = request.name!!,
                short_description = request.short_description!!,
                description = request.description!!,
                create_dt = LocalDateTime.now(),
                modify_dt = LocalDateTime.now()
            )
        )
    }

    override fun update(id: Int, request: UpdateArticleRequest) {
        log.info("Update article with id=$id")
        val article = ArticleDao.findByIdOrNull(id) ?: throw ArticleNotFoundException(id)
        ArticleDao.save(
            article.copy(
                name = request.name!!,
                short_description = request.short_description!!,
                description = request.description!!,
                modify_dt = LocalDateTime.now()
            )
        )
    }

    override fun delete(id: Int) {
        log.info("Delete article with id=$id")
        val article = ArticleDao.findByIdOrNull(id) ?: throw ArticleNotFoundException(id)
        ArticleDao.delete(article)
    }

    companion object {
        private val log = LoggerFactory.getLogger(ArticleServiceImpl::class.java)
    }
}