package com.study.library.controller.book

import com.study.library.dto.book.request.BookLoanRequest
import com.study.library.dto.book.request.BookRequest
import com.study.library.dto.book.request.BookReturnRequest
import com.study.library.dto.book.response.BookStatisticsResponse
import com.study.library.service.book.BookService
import org.springframework.web.bind.annotation.*

@RestController
class BookController(
    private val bookService: BookService
) {

    @PostMapping("/book")
    fun saveBook(@RequestBody bookRequest: BookRequest) {
        bookService.saveBook(bookRequest)
    }

    @PostMapping("/book/loan")
    fun loanBook(@RequestBody bookLoanRequest: BookLoanRequest) {
        bookService.loanBook(bookLoanRequest)
    }

    @PutMapping("/book/return")
    fun returnBook(@RequestBody bookReturnRequest: BookReturnRequest) {
        bookService.returnBook(bookReturnRequest)
    }

    /**
     * 현재 대여 중인 책의 권수 보여주기
     */
    @GetMapping("/book/loan")
    fun countLoanedBook(): Int {
        return bookService.countLoanedBook()
    }

    /**
     * 분야 별로 등록되어 있는 책의 권수 보여주기
     */
    @GetMapping("/book/statistics")
    fun findBookStatistics(): List<BookStatisticsResponse> {
        return bookService.findBookStatistics()
    }

}