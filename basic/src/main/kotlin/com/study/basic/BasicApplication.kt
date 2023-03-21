package com.study.basic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BasicApplication

fun main(args: Array<String>) {
    runApplication<BasicApplication>(*args)
}