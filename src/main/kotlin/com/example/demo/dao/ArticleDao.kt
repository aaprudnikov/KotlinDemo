

package com.example.demo.dao

import org.springframework.data.repository.CrudRepository
import com.example.demo.model.Article

interface ArticleDao : CrudRepository<Article, Int> {

    fun findByOrderByName(): List<Article>
}