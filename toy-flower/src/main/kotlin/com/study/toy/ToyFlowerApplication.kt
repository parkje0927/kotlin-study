package com.study.toy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class ToyFlowerApplication

fun main(args: Array<String>) {
    runApplication<ToyFlowerApplication>(*args)
}
