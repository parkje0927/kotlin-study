package com.study.library.service

import com.study.library.domain.book.Book
import com.study.library.domain.book.BookRepository
import com.study.library.domain.book.BookType
import com.study.library.domain.user.User
import com.study.library.domain.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TempService(
    private val userRepository: UserRepository,
    private val bookRepository: BookRepository
) {

    /**
     * @txHelper 를 위한 임시 코드
     */
    @Transactional
    fun saveUserAndLoanTwoBooks() {
        val user = User("A", 30)
        val books = bookRepository.saveAll(
            listOf(
                Book("book1", BookType.COMPUTER), Book("book2", BookType.ECONOMY)
            )
        )
        books.forEach { book -> user.loanBook(book) }
        userRepository.save(user)
    }
}