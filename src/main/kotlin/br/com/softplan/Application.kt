@file:JvmName("Application")

package br.com.softplan

import br.com.softplan.controller.UserController
import br.com.softplan.controller.VersionController
import io.javalin.Javalin
import org.eclipse.jetty.http.HttpStatus

class Application {
    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            val app = Javalin.create()
                .get("/api/users", UserController::users)
                .get("/api/users/:username", UserController::user)
                .get("/api/*") { ctx -> ctx.status(HttpStatus.BAD_REQUEST_400) }                // Any unmapped API will result in a 400 Bad Request
                .get("/version", VersionController::version)

            app.config
                .addStaticFiles("/spa")                                     // The ReactJS application
                .addStaticFiles("/assets")                                        // Other static assets, external to the ReactJS application
                .addSinglePageRoot("/", "/spa/index.html")   // Catch-all route for the single-page application
            val port = when {
                System.getenv("PORT").isNullOrEmpty() -> 8080
                else -> System.getenv("PORT").toInt()
            }
            app.start(port)
        }
    }
}
