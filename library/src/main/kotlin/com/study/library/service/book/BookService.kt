package com.study.library.service.book

import com.study.library.domain.book.Book
import com.study.library.domain.book.BookRepository
import com.study.library.domain.user.UserLoanHistoryRepository
import com.study.library.domain.user.UserLoanStatus
import com.study.library.domain.user.UserRepository
import com.study.library.dto.book.request.BookLoanRequest
import com.study.library.dto.book.request.BookRequest
import com.study.library.dto.book.request.BookReturnRequest
import com.study.library.dto.book.response.BookStatisticsResponse
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

    @Transactional(readOnly = true)
    fun countLoanedBook(): Int {
        return userLoanHistoryRepository.findAllByStatus(UserLoanStatus.LOANED).size
    }

    @Transactional(readOnly = true)
    fun findBookStatistics(): List<BookStatisticsResponse> {
//        val results = mutableListOf<BookStatisticsResponse>()
//        val books = bookRepository.findAll()

//        for (book in books) {
//            //만들어 둔 응답 dto 결과에 book type 이 있다면 1을 더해주고, 없다면 새로 넣어준다.
//            val targetDto = results.firstOrNull { dto -> book.type == dto.type }
//            if (targetDto == null) {
//                results.add(BookStatisticsResponse(book.type, 1))
//            } else {
//                targetDto.plusOne()
//            }
//        }
//        return results

//        for (book in books) {
//            //?. => null 이 아닌 경우(존재하는 경우) plusOne
//            //?: => 그렇지 않으면(존재하지 않은 경우) 새로 만들어준다.
//            results.firstOrNull { dto -> dto.type == book.type }?.plusOne()
//                ?: results.add(BookStatisticsResponse(book.type, 1))
//        }
//        return results

        return bookRepository.findAll()
            .groupBy { book -> book.type } //Map<BookType, List<Book>>
            .map { (type, books) -> BookStatisticsResponse(type, books.size) }
    }

}