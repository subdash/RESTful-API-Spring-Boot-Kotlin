package com.example.demo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("/api")
class TimeController {
    @GetMapping("/timeOfDay")
    fun time() = SimpleDateFormat("HH:mm:ss").format(Date())
}
