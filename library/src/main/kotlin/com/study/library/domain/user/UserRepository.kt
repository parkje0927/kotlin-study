package com.study.library.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>, UserRepositoryCustom {

    /**
     * 코틀린에서는 언어 자체의 타입 시스템이 물음표를 통해서 어떤 값이 널인지 아닌지 알려주기 때문에 Optional 이 필요가 없다.
     * Optional<User> -> User? 로 변경해주면 null 혹은 실제 User 값을 넣어준다.
     */
    fun findByName(name: String): User?

    /**
     * 대출 기록이 없는 유저도 조회 => left join
     * fetch => join 한번만 쓰는 쿼리가 나간다.
     *
     * select
     *         distinct u1_0.id,
     *         u1_0.age,
     *         u1_0.name,
     *         u2_0.user_id,
     *         u2_0.id,
     *         u2_0.book_name,
     *         u2_0.status
     *     from
     *         user u1_0
     *     left join
     *         user_loan_history u2_0
     *             on u1_0.id=u2_0.user_id
     */
//    @Query("select distinct u from User u left join fetch u.userLoanHistories")
//    fun findAllWithHistories(): List<User>

    //-> querydsl 로 변경
}