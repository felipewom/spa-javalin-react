/*
 * This file is part of Spa.
 *
 * Copyright (C) 2019
 * Caprica Software Limited (capricasoftware.co.uk)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.softplan.repository

import br.com.softplan.domain.User

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
