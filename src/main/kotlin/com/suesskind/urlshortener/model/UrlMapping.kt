package com.suesskind.urlshortener.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "urlMappings")
data class UrlMapping(
    @Id
    val id: String? = null,
    val originalUrl: String,
    val shortUrl: String
)
