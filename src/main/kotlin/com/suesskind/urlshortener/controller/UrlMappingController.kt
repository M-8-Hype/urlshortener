package com.suesskind.urlshortener.controller

import com.suesskind.urlshortener.service.UrlMappingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/url")
class UrlMappingController(
    private val urlMappingService: UrlMappingService
) {
    @PostMapping("/shorten")
    fun shortenUrl(@RequestBody originalUrl: String): ResponseEntity<String> {
        return ResponseEntity.ok(urlMappingService.shortenUrl(originalUrl))
    }

    @GetMapping("/{shortUrl}")
    fun getOriginalUrl(@PathVariable shortUrl: String): ResponseEntity<String> {
        return urlMappingService.getOriginalUrl(shortUrl)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }
}