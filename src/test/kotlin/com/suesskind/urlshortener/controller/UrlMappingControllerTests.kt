package com.suesskind.urlshortener.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class UrlMappingControllerTests(
    @Autowired
    private val mockMvc: MockMvc
) {

    @Test
    fun `should shorten URL`() {
        mockMvc.perform(post("/api/url/shorten")
            .content("https://dkbcodefactory.com/")
            .contentType("text/plain"))
            .andExpect(status().isOk)
    }

    @Test
    fun `should return original URL`() {
        mockMvc.perform(get("/api/url/ba31b9da"))
            .andExpect(status().isOk)
    }

    @Test
    fun `should return not found`() {
        mockMvc.perform(get("/api/url/notfound"))
            .andExpect(status().isNotFound)
    }
}