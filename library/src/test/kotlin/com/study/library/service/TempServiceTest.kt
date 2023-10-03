package com.study.library.service

import com.study.library.domain.user.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TempServiceTest @Autowired constructor(
    private val tempService: TempService,
    private val userRepository: UserRepository,
    private val txHelper: TxHelper
) {

    @Test
    fun `유저 1명과 책 2권을 저장하고 대출한다`() {
        //when
        tempService.saveUserAndLoanTwoBooks()

        //then
        txHelper.execute {
            val users = userRepository.findAll()
            assertThat(users).hasSize(1)
            assertThat(users[0].userLoanHistories).hasSize(2)
        }
    }
}