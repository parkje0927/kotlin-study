package com.study.toy.controller

import com.study.toy.dto.request.BoardSaveRequest
import com.study.toy.dto.response.MessageResponse
import com.study.toy.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(
    private val boardService: BoardService
) {

    @PostMapping("/api/board")
    fun saveBoard(@RequestBody boardSaveRequest: BoardSaveRequest): ResponseEntity<MessageResponse> {
        boardService.saveBoard(boardSaveRequest)
        return ResponseEntity.ok().body(MessageResponse.of(HttpStatus.OK.value(), "저장 성공"))
    }
}