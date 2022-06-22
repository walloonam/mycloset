package com.sw.mycloset.controller

import com.sw.mycloset.service.ClosetService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/closet")
class ClosetController (
    private val closetService: ClosetService
        ){
    @GetMapping
    fun getCloset() = closetService.getCloset()

    @PostMapping
    fun insertCloset(@RequestBody closetRequest: ClosetRequest)= closetService.insertCloset(closetRequest.closetUser ,closetRequest.closetName, closetRequest.priorty)

    @PutMapping(path=["{closetId}"])
    fun updateCloset(@PathVariable("closetId") closetId: Long, @RequestBody closetRequest: ClosetRequest) = closetService.updateCloset(closetId,closetRequest.priorty)

    @DeleteMapping(path=["{closetId}"])
    fun deleteCloset(@PathVariable("closetId") closetId: Long) = closetService.deleteCloset(closetId)
}