package com.study.library.dto.book.request

data class BookLoanRequest(
    val userName: String,
    val bookName: String
)

/**
 * dto 를 취지에 맞게 data class 로 변경
 * equals, hashCode 를 활용할 때가 있기 때문
 */