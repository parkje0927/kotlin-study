package com.study.library.service.book

import com.study.library.domain.book.Book
import com.study.library.domain.book.BookRepository
import com.study.library.domain.user.UserRepository
import com.study.library.domain.user.UserLoanHistoryRepository
import com.study.library.domain.user.UserLoanStatus
import com.study.library.dto.book.request.BookLoanRequest
import com.study.library.dto.book.request.BookRequest
import com.study.library.dto.book.request.BookReturnRequest
import com.study.library.util.fail
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
) {

    /**
     * Optional 객체를 써서 .orElseThrow(::IllegalArgumentException) 를 작성한 부분이
     * -> ?: throw IllegalArgumentException()
     * -> ?: fail()
     * 이렇게 변경됨.
     *
     * -> 여기서 ExceptionUtils 에서 확장함수 만들어서 사용하면 findById 의 경우 -> findByIdOrNull -> findByIdOrThrow 가 된다.
     */

    @Transactional
    fun saveBook(request: BookRequest) {
        val book = Book(request.name, request.type)
        bookRepository.save(book)
    }

    @Transactional
    fun loanBook(request: BookLoanRequest) {
//        val book = bookRepository.findByName(request.bookName).orElseThrow(::IllegalArgumentException)
//        val book = bookRepository.findByName(request.bookName) ?: throw IllegalArgumentException()
        val book = bookRepository.findByName(request.bookName) ?: fail()
        if (userLoanHistoryRepository.findByBookNameAndStatus(request.bookName, UserLoanStatus.LOANED) != null) {
            throw IllegalArgumentException("이미 대출된 책입니다.")
        }

        val user = userRepository.findByName(request.userName) ?: fail()
        user.loanBook(book)
    }

    @Transactional
    fun returnBook(request: BookReturnRequest) {
        val user = userRepository.findByName(request.userName) ?: fail()
        user.returnBook(request.bookName)
    }

}