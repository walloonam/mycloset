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

    fun insertCloset(closetUser: String,  closetName : String, priorty: Boolean): Closet = closetRepository.save(Closet(closetUser= closetUser, closetName = closetName, priorty = priorty))

    fun updateCloset(closetId: Long, priorty: Boolean): Closet {
        val closet = closetRepository.findByIdOrNull(closetId) ?: throw Exception()
        closet.priorty=priorty
        return closetRepository.save(closet)
    }

    fun deleteCloset(closetId: Long) = closetRepository.deleteById(closetId)
}

