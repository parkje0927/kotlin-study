package com.study.library.dto.user.response

data class UserLoanHistoryResponse(
    val name: String, //username
    val books: List<BookHistoryResponse>
)

data class BookHistoryResponse(
    val name: String, //bookName
    val isReturn: Boolean
)