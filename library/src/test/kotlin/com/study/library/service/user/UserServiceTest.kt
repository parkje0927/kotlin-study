package com.study.library.service.user

import com.study.library.domain.user.User
import com.study.library.domain.user.UserRepository
import com.study.library.dto.user.request.UserCreateRequest
import com.study.library.dto.user.request.UserUpdateRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService
) {

    @AfterEach
    fun cleanAfter() {
        userRepository.deleteAll()
    }

    @Test
    fun saveUserTest() {
        //given
        val userCreateRequest = UserCreateRequest("test", null)

        //when
        userService.saveUser(userCreateRequest)

        //then
        val users = userRepository.findAll()
        assertThat(users).hasSize(1)
        assertThat(users[0].name).isEqualTo("test")
        assertThat(users[0].age).isNull()
    }

    @Test
    fun getUsersTest() {
        //given
        userRepository.saveAll(
            listOf(
                User("A", 20),
                User("B", 30)
            )
        )

        //when
        val users = userService.getUsers()

        //then
        assertThat(users).extracting("name").containsExactlyInAnyOrder("A", "B")
        assertThat(users).extracting("age").containsExactlyInAnyOrder(20, 30)
    }

    @Test
    fun updateUserNameTest() {
        //given
        val savedUser = userRepository.save(User("A", 20))
        val userUpdateRequest = UserUpdateRequest(savedUser.id!!, "B")

        //when
        userService.updateUserName(userUpdateRequest)

        //then
        val user = userRepository.findAll()[0]
        assertThat(user.name).isEqualTo("B")
    }

    @Test
    fun deleteUserTest() {
        //given
        userRepository.save(User("test", 25))

        //when
        userService.deleteUser("test")

        //then
        assertThat(userRepository.findAll()).isEmpty()
    }
}