package com.sw.mycloset.service

import com.sw.mycloset.repository.Closet
import com.sw.mycloset.repository.ClosetRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ClosetService (
    private val closetRepository: ClosetRepository
        ){
    fun getCloset() =  closetRepository.findAll()

    fun insertCloset(closetUser: String,  closetName : String): Closet = closetRepository.save(Closet(closetUser= closetUser, closetName = closetName))

    fun updateCloset(closetId: Long): Closet {
        val closet = closetRepository.findByIdOrNull(closetId) ?: throw Exception()
        return closetRepository.save(closet)
    }

    fun deleteCloset(closetId: Long) = closetRepository.deleteById(closetId)
}

