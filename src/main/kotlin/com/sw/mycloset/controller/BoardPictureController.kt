package com.sw.mycloset.controller

import com.sw.mycloset.repository.BoardPicture
import com.sw.mycloset.service.BoardPictureService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/boardPicture")
class BoardPictureController (
    private val boardPictureService: BoardPictureService
        ){
    @GetMapping
    @CrossOrigin("http://localhost:8080/")
    fun getBoardPicture()= boardPictureService.getBoardPicture()

    @CrossOrigin("http://localhost:8080/")
    @PostMapping(consumes=arrayOf(MediaType.MULTIPART_FORM_DATA_VALUE))
    fun insertBoardPicture(@ModelAttribute boardPictureRequest: BoardPictureRequest) {
        boardPictureService.insertBoardPicture(boardPictureRequest.file)
    }
    @PutMapping(path=["{boardPictureId}"])
    @PostMapping(consumes=arrayOf(MediaType.MULTIPART_FORM_DATA_VALUE))
    fun updateBoardPicture(@PathVariable("boardPictureId") boardPictureId: Long,
                           @ModelAttribute boardPictureRequest: BoardPictureRequest
    )= boardPictureService.updateBoardPicture(boardPictureId,boardPictureRequest.file)

    @DeleteMapping(path=["{boardPictureId}"])
    fun deleteBoardPicture(@PathVariable("boardPictureId") boardPictureId: Long)= boardPictureService.deleteBoardPicture((boardPictureId))

}
