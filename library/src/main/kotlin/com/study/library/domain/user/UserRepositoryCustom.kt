package com.study.library.domain.user

interface UserRepositoryCustom {

    /**
     * 아래 상황을 가정한다면,
     * (1 : N)
     * User -< UserLoanHistory
     * User -< UserPrivacy
     * -> fetch join 은 1개의 N 에 대해서만 사용할 수 있다!
     */
    fun findAllWithHistories(): List<User>
}