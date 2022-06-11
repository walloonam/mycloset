package com.sw.mycloset.controller

import com.sw.mycloset.repository.BoardPicture
import org.springframework.web.multipart.MultipartFile

data class BoardPictureRequest (val file : MultipartFile)
