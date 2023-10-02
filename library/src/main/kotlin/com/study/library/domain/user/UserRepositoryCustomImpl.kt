package com.study.library.domain.user

import com.querydsl.jpa.impl.JPAQueryFactory
import com.study.library.domain.user.QUser.user
import com.study.library.domain.user.QUserLoanHistory.userLoanHistory

class UserRepositoryCustomImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : UserRepositoryCustom {

    override fun findAllWithHistories(): List<User> {
        return jpaQueryFactory.select(user).distinct()
            .from(user)
            .leftJoin(userLoanHistory).on(userLoanHistory.user.id.eq(user.id)).fetchJoin()
            .fetch()
    }
}