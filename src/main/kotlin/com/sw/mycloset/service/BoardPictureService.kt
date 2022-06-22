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

        var projectPath: String = System.getProperty("user.dir") + "\\src\\main\\kotlin\\com\\sw\\mycloset\\images"

        var uuid : UUID = UUID.randomUUID();
        /*uuid.toString() + "_" +*/

        var fileName: String = file.originalFilename.toString()

        var saveFile: File = File(projectPath, fileName)

        file.transferTo(saveFile)

        var boardPicture: BoardPicture = BoardPicture(fileName = fileName, filePath = "files/" + '1'+fileName)

        boardPictureRepository.save(boardPicture)

    }

    fun updateBoardPicture(boardPictureId: Long,file: MultipartFile): BoardPicture{
        val boardPicture = boardPictureRepository.findByIdOrNull(boardPictureId) ?: throw Exception()
        val projectPath: String = System.getProperty("user.dir") + "\\src\\main\\kotlin\\com\\sw\\mycloset\\images"
        val fileName: String = file.originalFilename.toString()
        val saveFile: File = File(projectPath, fileName)
        file.transferTo(saveFile)
        boardPicture.fileName=fileName
        boardPicture.filePath="files/" + '1'+fileName
        return boardPictureRepository.save(boardPicture)
    }

    fun deleteBoardPicture(boardPictureId: Long) = boardPictureRepository.deleteById(boardPictureId)

}
