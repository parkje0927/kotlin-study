package com.study.library.domain.user

interface UserRepositoryCustom {

    fun findAllWithHistories(): List<User>
}