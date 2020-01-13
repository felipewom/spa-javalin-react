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

package br.com.softplan.controller

import br.com.softplan.service.UserService
import br.com.softplan.service.UserServiceImpl
import io.javalin.http.Handler
import br.com.softplan.domain.User
import io.javalin.http.Context

import java.util.Optional

/**
 * An example web service API controller.
 */
object UserController {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private val userService = UserServiceImpl()

    fun users(ctx:Context){
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }

        ctx.json(userService.users())
    }

    fun user(ctx:Context){
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }

        val user = userService.user(ctx.pathParam("username"))
        if (user.isPresent) {
            ctx.json(user)
        }
        ctx.status(404)
    }

}
