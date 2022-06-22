package com.sw.mycloset.controller

import com.sw.mycloset.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController (
    private val userService: UserService
        ){
    @GetMapping
    fun getUser() = userService.getUser()

    @PostMapping
    fun insertUser(@RequestBody userRequest: UserRequest) = userService.insertUser( userRequest.userEmail, userRequest.userName ,userRequest.userPwd)

    @PutMapping(path = ["/{userId}"])
    fun updateUser(@PathVariable("userId") userId: Long, @RequestBody userRequest: UserRequest) = userService.updateUser(userId,userRequest.userEmail, userRequest.userName ,userRequest.userPwd )

    @DeleteMapping(path = ["/{userId}"])
    fun deleteUser(@PathVariable("userId") userId: Long) = userService.deleteUser(userId)
}