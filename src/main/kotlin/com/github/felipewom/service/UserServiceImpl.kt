package com.github.felipewom.service

import com.github.felipewom.domain.User
import com.github.felipewom.repository.MemoryUserRepository
import com.github.felipewom.repository.UserRepository
import java.util.Optional

class UserServiceImpl : UserService {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private val userRepository = MemoryUserRepository()

    override fun user(username: String): Optional<User> {
        return userRepository.readUser(username)
    }

    override fun users(): List<User> {
        return userRepository.readUsers()
    }

}
