package com.github.felipewom.service

import com.github.felipewom.domain.User
import java.util.Optional

/**
 * Business service dealing with Users.
 */
interface UserService {

    fun users(): List<User>

    fun user(username: String): Optional<User>

}
