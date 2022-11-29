package com.example

import io.micronaut.context.env.PropertySource.mapOf
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
//import java.util.Scanner
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.json.tree.JsonObject

@Controller("/text")
open class MessageController {

    /*@Post(value = "/analyze", consumes = [MediaType.TEXT_PLAIN])
    open fun echo(@Body text: String): String {
        return text
    }*/

    @Post(value = "/analyze",consumes = [MediaType.APPLICATION_JSON])
    open fun echoFlow(@Body response: JsonObject):HttpResponse<*>   //MutableMap<String, Any>?
    {


        val  text:String = response.get("content").stringValue

//          println(text)

        var word_count=1
        var character_count_with_space=0
        var character_count_without_spaces=0
        var line_count=0
        var uniqe_words =0
        var sz: Int =text.length;
        val tokens = text.split(" ").toTypedArray()
//        println(tokens)
        val seta= tokens.toSet()
        println(seta)
        for(i in 0..sz-1) {
            if (text[i] == ' ') {
                character_count_with_space+=1;
                word_count+=1
            }
            else if(text[i]!='.' && text[i]!=','){
                character_count_with_space+=1;
                character_count_without_spaces += 1
            }
            else
                character_count_with_space+=1
            if(text[i]=='.')
                line_count+=1
        }

        uniqe_words=seta.size
        val result = mutableMapOf(
            "word_count" to word_count,
            "character_count_with_spaces" to character_count_with_space,
            "character_count_without_spaces" to character_count_without_spaces,
            "line_count" to line_count,
            "unique_words" to uniqe_words
        )

        return HttpResponse.ok(result)
        //val map = mapOf("word_count" to word_count, "character_count_with_space" to character_count_with_space , "character_count_without_spaces" to character_count_with_space, "line_count" to line_count )
        //return HttpResponse.status<Any>(HttpStatus.UNAUTHORIZED).body(map)
        //return map;
// return HttpResponse.ok(mapOf("word_count" to word_count, "character_count_with_space" to character_count_with_space, "character_count_without_spaces" to character_count_without_spaces, "line_count" to line_count ))
    }
}


