package com.study.library.repository.user

import com.querydsl.jpa.impl.JPAQueryFactory
import com.study.library.domain.user.QUserLoanHistory.userLoanHistory
import com.study.library.domain.user.UserLoanHistory
import com.study.library.domain.user.UserLoanStatus
import org.springframework.stereotype.Component

@Component
class UserLoanHistoryQuerydslRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {
    /**
     * status => nullable 하게 받고 default 를 null 로 처리해줌으로써
     * -> status 없이 bookName 만으로 조건을 걸수도 있고, 아니면 bookName, status 같이 걸수도 있게 된다.
     */
    fun findByBookNameAndStatus(bookName: String, status: UserLoanStatus? = null): UserLoanHistory? {
        return jpaQueryFactory.selectFrom(userLoanHistory)
            .where(
                userLoanHistory.bookName.eq(bookName),
                status?.let { userLoanHistory.status.eq(status) }
            )
            .limit(1)
            .fetchOne()
    }

    fun countByStatus(status: UserLoanStatus): Long {
        return jpaQueryFactory.select(userLoanHistory.count())
            .from(userLoanHistory)
            .where(userLoanHistory.status.eq(status))
            .fetchOne() ?: 0L //혹시 비어있는 경우를 대비하여 0L 을 반환하도록 처리
    }

}