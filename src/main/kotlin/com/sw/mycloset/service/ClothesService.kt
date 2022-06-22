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
        clothesUser: String,
        clothesName: String,
        clothesCloset: String,
        clothesCategory: String,
        clothesBuy: String,
        clothesSeason: String,
        ):Clothes = clothesRepository.save(
                Clothes(
                    clothesUser = clothesUser,
                    clothesName = clothesName,
                    clothesCloset = clothesCloset,
                    clothesCategory = clothesCategory,
                    clothesBuy = clothesBuy,
                    clothesSeason = clothesSeason,
                )
        )


    fun updateClothes(clothesId: Long,
                      clothesUser: String,
                      clothesName: String,
                      clothesCloset: String,
                      clothesCategory: String,
                      clothesBuy: String,
                      clothesSeason: String,
    ): Clothes{
        val clothes = clothesRepository.findByIdOrNull(clothesId) ?: throw Exception()
        clothes.clothesUser=clothesUser
        clothes.clothesName=clothesName
        clothes.clothesCloset=clothesCloset
        clothes.clothesCategory=clothesCategory
        clothes.clothesBuy=clothesBuy
        clothes.clothesSeason=clothesSeason
        return clothesRepository.save(clothes)
    }

    fun deleteClothes(clothesId: Long) = clothesRepository.deleteById(clothesId)
}