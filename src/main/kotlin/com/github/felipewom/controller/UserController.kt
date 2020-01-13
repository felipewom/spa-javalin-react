package com.github.felipewom.controller

import com.github.felipewom.service.UserService
import com.github.felipewom.service.UserServiceImpl
import io.javalin.http.Handler
import com.github.felipewom.domain.User
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
