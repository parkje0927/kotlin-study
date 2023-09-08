package com.study.library.dto.user.response

import com.study.library.domain.user.User

class UserResponse(
    val id: Long,
    val name: String,
    val age: Int?
) {

    companion object {
        fun of(user: User): UserResponse {
            return UserResponse(
                id = user.id!!,
                name = user.name,
                age = user.age
            )
        }
    }

    //init 보다는 부생성자 사용!! -> 이것보다 정적 팩토리 메소드 사용!!
//    constructor(user: User): this(
//        id = user.id!!,
//        name = user.name,
//        age = user.age
//    )

//    init {
//        id = user.id!!
//        name = user.name
//        age = user.age
//    }
}