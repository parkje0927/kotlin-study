package com.study.toy.dto.response

class MessageResponse(
    val status: Int,
    val message: String
) {
    companion object {
        fun of(status: Int, message: String): MessageResponse {
            return MessageResponse(status = status, message = message)
        }
    }
}