package com.gdgo.spring.template.web

import org.springframework.web.bind.annotation.GetMapping

@ApiV1Controller
class HelloController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World"
    }
}
