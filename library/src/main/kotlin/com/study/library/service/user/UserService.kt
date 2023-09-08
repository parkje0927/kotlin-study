package com.study.library.service.user

import com.study.library.domain.user.User
import com.study.library.domain.user.UserRepository
import com.study.library.dto.user.request.UserCreateRequest
import com.study.library.dto.user.request.UserUpdateRequest
import com.study.library.dto.user.response.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    //의존성 주입 완료
    private val userRepository: UserRepository
) {

    /**
     * class, function 모두 기본적으로 override 가 불가능하고,
     * 열어주고 싶다면 앞에 open 을 붙여줘야한다.
     * 매번 붙이기 귀찮으니, plugin 을 넣어줘야 한다.
     * -> kotlin("plugin.spring") version "1.8.22"
     */
    @Transactional
    fun saveUser(request: UserCreateRequest) {
        val user = User(request.name, request.age)
        userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun getUsers(): List<UserResponse> {
//        return userRepository.findAll().map { UserResponse.of(it) }
        return userRepository.findAll().map { user -> UserResponse.of(user) }
    }

    @Transactional
    fun updateUserName(request: UserUpdateRequest) {
        val user = userRepository.findById(request.id).orElseThrow(::IllegalArgumentException)
        user.updateName(request.name)
    }

    @Transactional
    fun deleteUser(name: String) {
        val user = userRepository.findByName(name).orElseThrow(::IllegalArgumentException)
        userRepository.delete(user)
    }
}