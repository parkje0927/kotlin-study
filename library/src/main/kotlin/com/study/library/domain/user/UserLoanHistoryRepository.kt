package com.study.library.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long> {

    //필드 수가 많아질수록 메소드가 점점 많아지고 길어질 수 있다. -> querydsl 로 변경 필요
    fun findByBookNameAndStatus(bookName: String, userLoanStatus: UserLoanStatus): UserLoanHistory?

    fun findAllByStatus(userLoanStatus: UserLoanStatus): List<UserLoanHistory>
    fun countByStatus(loaned: UserLoanStatus): Long
}