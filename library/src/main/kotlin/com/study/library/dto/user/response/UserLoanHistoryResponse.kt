package com.study.library.dto.user.response

import com.study.library.domain.user.User
import com.study.library.domain.user.UserLoanHistory

data class UserLoanHistoryResponse(
    val name: String, //username
    val books: List<BookHistoryResponse>
) {
    companion object {
        fun of(user: User): UserLoanHistoryResponse {
            return UserLoanHistoryResponse(
                name = user.name,
                books = user.userLoanHistories.map(BookHistoryResponse::of)
            )
        }
    }
}

data class BookHistoryResponse(
    val name: String, //bookName
    val isReturn: Boolean
) {
    companion object {
        fun of(history: UserLoanHistory): BookHistoryResponse {
            return BookHistoryResponse(
                name = history.bookName,
                isReturn = history.isReturned,
            )
        }
    }
}