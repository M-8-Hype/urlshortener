package com.suesskind.urlshortener.repository

import com.suesskind.urlshortener.model.UrlMapping
import org.springframework.data.mongodb.repository.MongoRepository

interface UrlMappingRepository : MongoRepository<UrlMapping, String> {
    fun findByShortUrl(shortUrl: String): UrlMapping?
    fun findByOriginalUrl(originalUrl: String): UrlMapping?
}