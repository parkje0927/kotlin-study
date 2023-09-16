package com.study.library.dto.book.request

import com.study.library.domain.book.BookType

data class BookRequest(
    val name: String,
    val type: BookType
) {
}