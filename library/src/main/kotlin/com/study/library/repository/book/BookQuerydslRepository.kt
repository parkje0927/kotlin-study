package com.study.library.repository.book

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import com.study.library.domain.book.QBook.book
import com.study.library.dto.book.response.BookStatisticsResponse
import org.springframework.stereotype.Component

/**
 * 이전 custom, customImpl 클래스를 만드는 방법보다 간결하다.
 * but, 필요에 따라 service 단에서 repository 와 함께 아래 클래스도 빈 주입이 필요하다.
 *
 * => 멀티 모듈을 사용하는 경우 모듈 별로만 repository 를 쓰는 경우가 많아서 이 방법을 선호한다.
 */
@Component
class BookQuerydslRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {

    fun findBookStatistics(): List<BookStatisticsResponse> {
        return jpaQueryFactory.select(
            Projections.constructor(
                BookStatisticsResponse::class.java,
                book.type,
                book.id.count()
            )
        )
            .from(book)
            .groupBy(book.type)
            .fetch()
    }

}