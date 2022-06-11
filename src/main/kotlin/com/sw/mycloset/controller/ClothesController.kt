package com.sw.mycloset.controller

import com.sw.mycloset.service.ClothesService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/clothes")
class ClothesController (
    private val clothesService: ClothesService
        ){
    @GetMapping
    fun getClothes()= clothesService.getClothes()

    @PostMapping
    fun insetClothes(@RequestBody clothesRequest: ClothesRequest)= clothesService.insertClothes(clothesRequest.clothesName, clothesRequest.clothesCloset, clothesRequest.clothesCategory, clothesRequest.clothesBuy, clothesRequest.clothesSeason)

    @PutMapping(path=["{clothesId}"])
    fun updateClothes(@PathVariable("clothesId") clothesId: Long)= clothesService.updateClothes(clothesId)

    @DeleteMapping(path=["{clothesId}"])
    fun deleteClothes(@PathVariable("clothesId") clothesId: Long)= clothesService.deleteClothes(clothesId)

}