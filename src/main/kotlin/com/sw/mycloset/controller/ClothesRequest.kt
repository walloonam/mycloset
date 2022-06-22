package com.sw.mycloset.controller

import org.springframework.web.multipart.MultipartFile
import java.awt.Image
import java.util.Date

data class ClothesRequest (val clothesUser: String,val clothesName: String, val clothesCloset: String, val clothesCategory: String, val clothesBuy: String, val clothesSeason: String)