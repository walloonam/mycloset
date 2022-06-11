package com.sw.mycloset.controller

import com.sw.mycloset.repository.BoardPicture
import com.sw.mycloset.service.BoardPictureService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/boardPicture")
class BoardPictureController (
    private val boardPictureService: BoardPictureService
        ){
    @GetMapping
    fun getBoardPicture()= boardPictureService.getBoardPicture()

    @PostMapping(consumes=arrayOf(MediaType.MULTIPART_FORM_DATA_VALUE))
    fun insertBoardPicture(@ModelAttribute boardPictureRequest: BoardPictureRequest) {
        boardPictureService.insertBoardPicture(boardPictureRequest.file)
    }
    @PutMapping(path=["{boardPictureId}"])
    fun updateBoardPicture(@PathVariable("boardPictureId") boardPictureId: Long)= boardPictureService.updateBoardPicture(boardPictureId)

    @DeleteMapping(path=["{boardPictureId}"])
    fun deleteBoardPicture(@PathVariable("boardPictureId") boardPictureId: Long)= boardPictureService.deleteBoardPicture((boardPictureId))

}
