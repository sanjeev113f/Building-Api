package com.example
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

//import io.micronaut.http.MediaType

@Controller("/hello")
class HelloController {
    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        return "Welcome to Text analyzer"
    }
}
