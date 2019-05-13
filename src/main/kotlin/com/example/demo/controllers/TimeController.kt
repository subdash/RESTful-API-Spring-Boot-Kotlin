package com.example.demo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*
import java.util.TimeZone

@RestController
@RequestMapping("/api")
class TimeController {
    @GetMapping("/timeOfDay")
    fun time() = SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'")
            .apply { timeZone = TimeZone.getTimeZone("UTC") }
            .format(Date())
}
