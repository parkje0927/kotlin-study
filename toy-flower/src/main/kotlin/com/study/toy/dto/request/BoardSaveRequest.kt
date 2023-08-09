package com.study.toy.dto.request

import com.study.toy.entity.Board

data class BoardSaveRequest(
    val email: String,
    val title: String,
    val content: String
) {
    fun toEntity(): Board {
        return Board(email = email, title = title, content = content)
    }
}

