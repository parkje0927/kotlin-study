package com.study.library.service.book

import com.study.library.domain.book.Book
import com.study.library.domain.book.BookRepository
import com.study.library.domain.book.BookType
import com.study.library.domain.user.User
import com.study.library.domain.user.UserRepository
import com.study.library.domain.user.UserLoanHistory
import com.study.library.domain.user.UserLoanHistoryRepository
import com.study.library.domain.user.UserLoanStatus
import com.study.library.dto.book.request.BookLoanRequest
import com.study.library.dto.book.request.BookRequest
import com.study.library.dto.book.request.BookReturnRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository,
    private val bookService: BookService
) {

    @AfterEach
    fun cleanAfter() {
        //deleteAll => 자식 테이블까지 찾아서 삭제
        bookRepository.deleteAll()
        userRepository.deleteAll()
    }

    @Test
    fun saveBookTest() {
        //given
        val bookRequest = BookRequest("clean code", BookType.COMPUTER)

        //when
        bookService.saveBook(bookRequest)

        //then
        val books = bookRepository.findAll()
        assertThat(books).hasSize(1)
        assertThat(books[0].name).isEqualTo("clean code")
        assertThat(books[0].type).isEqualTo(BookType.COMPUTER)
    }

    @DisplayName("대출 정상 동작")
    @Test
    fun loanBookTest() {
        //given
        bookRepository.save(Book.fixture("clean code"))
        val savedUser = userRepository.save(User("test", 20))
        val bookLoanRequest = BookLoanRequest("test", "clean code")

        //when
        bookService.loanBook(bookLoanRequest)

        //then
        val userLoanHistories = userLoanHistoryRepository.findAll()
        assertThat(userLoanHistories).hasSize(1)
        assertThat(userLoanHistories[0].bookName).isEqualTo("clean code")
        assertThat(userLoanHistories[0].user.id).isEqualTo(savedUser.id)
        assertThat(userLoanHistories[0].status).isEqualTo(UserLoanStatus.LOANED)
    }

    @DisplayName("대출 실패")
    @Test
    fun loanBookFailTest() {
        //given
        bookRepository.save(Book.fixture("clean code"))
        val savedUser = userRepository.save(User("test", 20))
        userLoanHistoryRepository.save(UserLoanHistory.fixture(savedUser, "clean code"))

        val bookLoanRequest = BookLoanRequest("test", "clean code")

        //when, then
        val message = assertThrows<IllegalArgumentException> {
            bookService.loanBook(bookLoanRequest)
        }.message
        assertThat(message).isEqualTo("이미 대출된 책입니다.")
    }

    @DisplayName("반납 정상 동작")
    @Test
    fun returnBookTest() {
        //given
        val savedUser = userRepository.save(User("test", 20))
        userLoanHistoryRepository.save(UserLoanHistory.fixture(savedUser, "clean code"))
        val bookReturnRequest = BookReturnRequest("test", "clean code")

        //when
        bookService.returnBook(bookReturnRequest)

        //then
        val userLoanHistories = userLoanHistoryRepository.findAll()
        assertThat(userLoanHistories).hasSize(1)
        assertThat(userLoanHistories[0].status).isEqualTo(UserLoanStatus.RETURNED)
    }

}
