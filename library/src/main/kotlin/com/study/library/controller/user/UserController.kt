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

    //아래 코드도 가능
//    @GetMapping("/user")
//    fun getUsers(): List<UserResponse> = userService.getUsers()

    @PutMapping("/user")
    fun updateUserName(@RequestBody userUpdateRequest: UserUpdateRequest) {
        userService.updateUserName(userUpdateRequest)
    }

    //String? 으로 하면 required=false 가 된다.
    //그런데, ? 을 빼면 required=true 이다.
    @DeleteMapping("/user")
    fun deleteUser(@RequestParam name: String) {
        userService.deleteUser(name)
    }

}