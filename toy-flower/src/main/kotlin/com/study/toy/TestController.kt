package com.study.toy

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StatusController {

    @GetMapping("/test")
    fun test(): String {
        return "test"
    }
}