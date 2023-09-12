package com.study.library.controller.user

import com.study.library.dto.user.request.UserCreateRequest
import com.study.library.dto.user.request.UserUpdateRequest
import com.study.library.dto.user.response.UserResponse
import com.study.library.service.user.UserService
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/user")
    fun saveUser(@RequestBody userCreateRequest: UserCreateRequest) {
        userService.saveUser(userCreateRequest)
    }

    @GetMapping("/user")
    fun getUsers(): List<UserResponse> {
        return userService.getUsers()
    }

    @PutMapping("/user")
    fun updateUserName(@RequestBody userUpdateRequest: UserUpdateRequest) {
        userService.updateUserName(userUpdateRequest)
    }

    @DeleteMapping("/user")
    fun deleteUser(@RequestParam name: String) {
        userService.deleteUser(name)
    }

}