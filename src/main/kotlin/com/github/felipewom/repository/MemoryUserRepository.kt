package com.github.felipewom.repository

import com.github.felipewom.domain.User

import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.Optional

class MemoryUserRepository : UserRepository {

    override fun readUsers(): List<User> {
        return users.values.toList()
    }

    override fun readUser(username: String): Optional<User> {
        val user = users[username]
        return Optional.ofNullable(user)
    }

    companion object {

        private val users = mutableMapOf<String, User>()

        init {
            users.put("boss", User("boss", "Sword Saint Isshin"))
            users.put("emma", User("emma", "The Gentle Blade"))
            users.put("emo", User("emo", "Genichiro"))
            users.put("dad", User("dad", "Great Shinobi Owl"))
            users.put("bananas", User("bananas", "Guardian Ape"))
            users.put("granny", User("granny", "Lady Butterfly"))
            users.put("horseguy", User("horseguy", "Gyoubu Masataka Oniwa"))
            users.put("scorchio", User("scorchio", "Demon of Hatred"))
        }
    }

}
