package com.example

import io.micronaut.context.env.PropertySource.mapOf
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
//import java.util.Scanner
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/text")
open class MessageController {

    /*@Post(value = "/analyze", consumes = [MediaType.TEXT_PLAIN])
    open fun echo(@Body text: String): String {
        return text
    }*/

    @Post(value = "/analyze",consumes = [MediaType.TEXT_PLAIN])
    open fun echoFlow(@Body text: String):HttpResponse<*>   //MutableMap<String, Any>?
    {

        var word_count=1
        var character_count_with_space=0
        var character_count_without_spaces=0
        var line_count=1
        var uniqe_words =0
        var sz=text.length;
        for(i in 0..sz-1) {
            if (text[i] == ' ') {
                character_count_with_space+=1;
                word_count+=1
            }
            else{
                character_count_with_space+=1;
                character_count_without_spaces += 1
            }
        }
        //val map = mapOf("word_count" to word_count, "character_count_with_space" to character_count_with_space , "character_count_without_spaces" to character_count_with_space, "line_count" to line_count )
        //return HttpResponse.status<Any>(HttpStatus.UNAUTHORIZED).body(map)
        //return map;
        return HttpResponse.ok(mapOf("word_count" to word_count, "character_count_with_space" to character_count_with_space ))
    }
}



