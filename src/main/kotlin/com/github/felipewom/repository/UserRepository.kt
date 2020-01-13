package com.github.felipewom.repository

import com.github.felipewom.domain.User
import java.util.Optional

/**
 * Repository dealing with Users.
 */
interface UserRepository {

    fun readUsers(): List<User>

    fun readUser(username: String): Optional<User>

}
