package http.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController {
    @GetMapping("ping")
    fun pingPong(): String {
        return "pong"
    }
}