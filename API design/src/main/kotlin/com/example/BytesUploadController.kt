package com.example


import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.validation.constraints.Size

@Controller("/text")
open class MessageController {

    @Post(value = "/analyze", consumes = [MediaType.TEXT_PLAIN]) //
    open fun echo(@Body text: String): String { //
        return text
    }
}


