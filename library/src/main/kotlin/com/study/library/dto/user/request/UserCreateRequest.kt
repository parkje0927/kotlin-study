package com.study.library.dto.user.request

data class UserCreateRequest(
    val name: String,
    val age: Int?
)