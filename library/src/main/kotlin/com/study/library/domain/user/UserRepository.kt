package com.study.library.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    /**
     * 코틀린에서는 언어 자체의 타입 시스템이 물음표를 통해서 어떤 값이 널인지 아닌지 알려주기 때문에 Optional 이 필요가 없다.
     * Optional<User> -> User? 로 변경해주면 null 혹은 실제 User 값을 넣어준다.
     */
    fun findByName(name: String): User?
}