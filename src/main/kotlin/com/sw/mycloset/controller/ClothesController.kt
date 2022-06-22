package com.sw.mycloset.controller

import com.sw.mycloset.service.ClothesService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/clothes")
class ClothesController (
    private val clothesService: ClothesService
        ){
    @GetMapping
    fun getClothes()= clothesService.getClothes()

    @PostMapping
    fun insertClothes(@RequestBody clothesRequest: ClothesRequest) {
        clothesService.insertClothes(
            clothesRequest.clothesUser,
            clothesRequest.clothesName,
            clothesRequest.clothesCloset,
            clothesRequest.clothesCategory,
            clothesRequest.clothesBuy,
            clothesRequest.clothesSeason
        )
    }
    @PutMapping(path=["{clothesId}"])
    fun updateClothes(@PathVariable("clothesId") clothesId: Long,@RequestBody clothesRequest: ClothesRequest
    )= clothesService.updateClothes(clothesId,
        clothesRequest.clothesUser,
        clothesRequest.clothesName,
        clothesRequest.clothesCloset,
        clothesRequest.clothesCategory,
        clothesRequest.clothesBuy,
        clothesRequest.clothesSeason
    )

    @DeleteMapping(path=["{clothesId}"])
    fun deleteClothes(@PathVariable("clothesId") clothesId: Long)= clothesService.deleteClothes(clothesId)

}