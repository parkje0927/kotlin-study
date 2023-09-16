package com.study.library.domain.user.loanhistory

import org.springframework.data.jpa.repository.JpaRepository

interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long> {

    fun findByBookNameAndStatus(bookName: String, userLoanStatus: UserLoanStatus): UserLoanHistory?
}