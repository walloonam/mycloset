package com.sw.mycloset.controller

import java.awt.Image
import java.util.Date

data class ClothesRequest (val clothesName: String, val clothesCloset: String, val clothesCategory: String, val clothesBuy: Date, val clothesSeason: String)