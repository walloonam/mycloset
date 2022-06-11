package com.sw.mycloset.service

import com.sw.mycloset.repository.User
import com.sw.mycloset.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@RequiredArgsConstructor
@Service
class UserService (
    private val userRepository: UserRepository
    ){
    fun getUser() = userRepository.findAll()

    fun insertUser(userEmail: String,  userName: String, userPwd: String): User = userRepository.save(User(userEmail = userEmail, userName = userName, userPwd = userPwd))

    fun updateUser(userId: Long): User {
        val user = userRepository.findByIdOrNull(userId) ?: throw Exception()
        return userRepository.save(user)
    }

    fun deleteUser(userId: Long) = userRepository.deleteById(userId)
}

//, userName = userName, userPwd = userPwd