package com.study.library.service

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class TxHelper {

    @Transactional
    fun execute(block: () -> Unit) {
        block()
    }
}