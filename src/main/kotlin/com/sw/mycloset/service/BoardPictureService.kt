package com.sw.mycloset.service
import java.io.*
import com.sw.mycloset.repository.BoardPicture
import com.sw.mycloset.repository.BoardPictureRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.UUID
import javax.swing.text.html.HTML.Tag.S

@Service
class BoardPictureService (
    private val boardPictureRepository: BoardPictureRepository
        ){
    fun getBoardPicture() = boardPictureRepository.findAll()

    fun insertBoardPicture(file: MultipartFile){

        var projectPath: String = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files"

        var uuid : UUID = UUID.randomUUID();

        var fileName: String  = uuid.toString() + "_" + file.originalFilename

        var saveFile: File = File(projectPath, fileName)

        file.transferTo(saveFile)

        var boardPicture: BoardPicture = BoardPicture(fileName = fileName, filePath = "/files" + fileName)

        boardPictureRepository.save(boardPicture)

    }

    fun updateBoardPicture(boardPictureId: Long): BoardPicture{
        val boardPicture = boardPictureRepository.findByIdOrNull(boardPictureId) ?: throw Exception()
        return boardPictureRepository.save(boardPicture)
    }

    fun deleteBoardPicture(boardPictureId: Long) = boardPictureRepository.deleteById(boardPictureId)

}
