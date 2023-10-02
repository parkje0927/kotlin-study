package com.study.library.domain.book

import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {

    fun findByName(bookName: String): Book?

    /**
     * JPQL 의 단점
     * - 문자열이기 때문에 버그를 찾기가 어렵다.
     * - 일반 SQL 과 달라 복잡한 쿼리를 작성할 때마다 찾아봐야한다.
     * - 동적 쿼리를 작성할 때 함수가 계속해서 늘어난다.
     * - 프로덕션 코드 변경에 취약하다.
     */
//    @Query("select new com.study.library.dto.book.response.BookStatisticsResponse(b.type, count(b.id)) " +
//            "from Book b " +
//            "group by b.type")
//    fun findBookStatistics(): List<BookStatisticsResponse>

    //-> querydsl 로 변경
}
