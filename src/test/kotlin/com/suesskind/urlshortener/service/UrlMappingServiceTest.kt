package com.suesskind.urlshortener.service

import com.suesskind.urlshortener.model.UrlMapping
import com.suesskind.urlshortener.repository.UrlMappingRepository
import io.mockk.*
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class UrlMappingServiceTest {

    private val urlMappingRepository = mockk<UrlMappingRepository>()
    private val uuidGenerator = mockk<() -> UUID>()
    private val urlMappingService = UrlMappingService(urlMappingRepository, uuidGenerator)

    @Test
    fun `shortenUrl - should return a new shortened url`() {
        val originalUrl = "https://dkbcodefactory.com/"
        val uuid = UUID.randomUUID()
        val shortUrl = uuid.toString().substring(0, 8)

        every { urlMappingRepository.findByOriginalUrl(originalUrl) } returns null
        every { uuidGenerator.invoke() } returns uuid
        every { urlMappingRepository.save(any()) } answers { firstArg() }

        // when
        val result = urlMappingService.shortenUrl(originalUrl)

        // then
        assertEquals(shortUrl, result)
        verify { urlMappingRepository.save(withArg {
            assertEquals(originalUrl, it.originalUrl)
            assertEquals(shortUrl, it.shortUrl)
        }) }
    }

    @Test
    fun `shortenUrl - should return an existing shortened url`() {
        val originalUrl = "https://dkbcodefactory.com/"
        val shortUrl = "ba31b9da"

        every { urlMappingRepository.findByOriginalUrl(originalUrl) } returns UrlMapping(id = null, originalUrl, shortUrl)

        // when
        val result = urlMappingService.shortenUrl(originalUrl)

        // then
        assertEquals(shortUrl, result)
        verify(exactly = 0) { uuidGenerator.invoke() }
    }
}