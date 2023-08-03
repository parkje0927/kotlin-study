package com.study.toy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToyFlowerApplication

fun main(args: Array<String>) {
    runApplication<ToyFlowerApplication>(*args)
}
