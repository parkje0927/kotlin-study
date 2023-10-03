package com.study.library.service.user

import com.study.library.domain.user.*
import com.study.library.dto.user.request.UserCreateRequest
import com.study.library.dto.user.request.UserUpdateRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
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

    @DisplayName("대출 기록이 없는 유저")
    @Test
    fun getUserLoanHistoriesTest1() {
        //given
        userRepository.save(User("test", null))

        //when
        val userLoanHistories = userService.getUserLoanHistories()

        //then
        assertThat(userLoanHistories).hasSize(1)
        assertThat(userLoanHistories[0].name).isEqualTo("test")
        assertThat(userLoanHistories[0].books).isEmpty()
    }

    @DisplayName("대출 기록이 많은 유저 정상동작")
    @Test
    fun getUserLoanHistoriesTest2() {
        //given
        val savedUser = userRepository.save(User("test", null))
        userLoanHistoryRepository.saveAll(
            listOf(
                UserLoanHistory.fixture(savedUser, "book1", UserLoanStatus.LOANED),
                UserLoanHistory.fixture(savedUser, "book2", UserLoanStatus.LOANED),
                UserLoanHistory.fixture(savedUser, "book3", UserLoanStatus.RETURNED)
            )
        )

        //when
        val userLoanHistories = userService.getUserLoanHistories()

        //then
        assertThat(userLoanHistories).hasSize(1)
        assertThat(userLoanHistories[0].name).isEqualTo("test")
        assertThat(userLoanHistories[0].books).hasSize(3)
        assertThat(userLoanHistories[0].books).extracting("name")
            .containsExactlyInAnyOrder("book1", "book2", "book3")
        assertThat(userLoanHistories[0].books).extracting("isReturn")
            .containsExactlyInAnyOrder(false, false, true)
    }

    @DisplayName("대출 기록이 없는 유저와 많은 유저 정상동작")
    @Test
    fun getUserLoanHistoriesTest3() {
        //given
        val savedUsers = userRepository.saveAll(
            listOf(
                User("test1", null),
                User("test2", null),
                User("test3", null),
            )
        )

        userLoanHistoryRepository.saveAll(
            listOf(
                UserLoanHistory.fixture(savedUsers[0], "book1", UserLoanStatus.LOANED),
                UserLoanHistory.fixture(savedUsers[0], "book2", UserLoanStatus.LOANED),
                UserLoanHistory.fixture(savedUsers[1], "book4", UserLoanStatus.LOANED),
                UserLoanHistory.fixture(savedUsers[1], "book5", UserLoanStatus.RETURNED),
                UserLoanHistory.fixture(savedUsers[1], "book6", UserLoanStatus.RETURNED),
            )
        )

        //when
        val userLoanHistories = userService.getUserLoanHistories()

        //then
        assertThat(userLoanHistories).hasSize(3)

        val userTest1Result = userLoanHistories.first { it.name == "test1" }
        assertThat(userTest1Result.books).hasSize(2)
        assertThat(userTest1Result.books).extracting("name")
            .containsExactlyInAnyOrder("book1", "book2")
        assertThat(userTest1Result.books).extracting("isReturn")
            .containsExactlyInAnyOrder(false, false)

        val userTest2Result = userLoanHistories.first { it.name == "test2" }
        assertThat(userTest2Result.books).hasSize(3)
        assertThat(userTest2Result.books).extracting("name")
            .containsExactlyInAnyOrder("book4", "book5", "book6")
        assertThat(userTest2Result.books).extracting("isReturn")
            .containsExactlyInAnyOrder(false, true, true)

        val userTest3Result = userLoanHistories.first { it.name == "test3" }
        assertThat(userTest3Result.books).isEmpty()
    }

    /**
     * 영속성 컨텍스트
     * 방법 1)
     * - @Transactional 어노테이션을 통해 트랜잭션이 생기게 되고 -> 영속성 컨텍스트가 존재하게 된다.
     * -> 롤백이 가능해진다. 트랜잭션별로 테스트 격리가능하여 병렬 테스트도 가능 but 테스트 내성이 떨어진다.
     * -> but 테스트 코드에서 @Transactional 사용하는 것을 추천
     *
     * 방법 2)
     * - N 쪽의 Repository 를 사용한다. 그러면 @Transactional 이 없어도 테스트 성공한다.
     *
     * 방법 3)
     * - 아니면 UserRepository 에서 user 정보 가져올 때 N 쪽인 UserLoanHistory 쪽도 가져오는 메소드인, findAllWithHistories 를 사용하여
     * - user, userLoanHistory 를 한번에 가져오면 된다. but 1:N 관계가 여러개면 사용할 수 없다.
     *
     * 방법 4) txHelper 사용
     * - 서비스 코드에서만 @Transactional 을 사용할 수 있고,
     * - txHelper.execute 안에서는 @Transactional 이 존재하는 환경을 만들어줄 수 있다.
     */

}