package com.sw.mycloset.service

import com.sw.mycloset.repository.Clothes
import com.sw.mycloset.repository.ClothesRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClothesService(
    private val clothesRepository: ClothesRepository
){
    fun getClothes() = clothesRepository.findAll()

    fun insertClothes(
        clothesName: String,
        clothesCloset: String,
        clothesCategory: String,
        clothesBuy: Date,
        clothesSeason: String
    ): Clothes =  clothesRepository.save(Clothes(clothesName = clothesName, clothesCloset = clothesCloset, clothesCategory = clothesCategory, clothesBuy = clothesBuy, clothesSeason = clothesSeason))

    fun updateClothes(clothesId: Long): Clothes{
        val clothes = clothesRepository.findByIdOrNull(clothesId) ?: throw Exception()
        return clothesRepository.save(clothes)
    }

    fun deleteClothes(clothesId: Long) = clothesRepository.deleteById(clothesId)
}