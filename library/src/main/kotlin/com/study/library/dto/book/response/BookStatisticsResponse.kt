package com.study.library.dto.book.response

import com.study.library.domain.book.BookType

data class BookStatisticsResponse(
    val type: BookType,
    val count: Long
) {
//    fun plusOne() {
//        count++
//    }
}
