package com.suesskind.urlshortener.service

import com.suesskind.urlshortener.model.UrlMapping
import com.suesskind.urlshortener.repository.UrlMappingRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UrlMappingService(
    private val urlMappingRepository: UrlMappingRepository,
    private val uuidGenerator: () -> UUID = { UUID.randomUUID() }
) {
    fun shortenUrl(originalUrl: String): String {
        urlMappingRepository.findByOriginalUrl(originalUrl)?.let {
            return it.shortUrl
        }
        val shortUrl = uuidGenerator().toString().substring(0, 8)
        val urlMapping = UrlMapping(originalUrl = originalUrl, shortUrl = shortUrl)
        urlMappingRepository.save(urlMapping)
        return shortUrl
    }

    fun getOriginalUrl(shortUrl: String): String? {
        val urlMapping = urlMappingRepository.findByShortUrl(shortUrl)
        return urlMapping?.originalUrl
    }
}