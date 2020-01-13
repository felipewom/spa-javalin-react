package com.github.felipewom.controller

import io.javalin.http.Context

/**
 * An example web service API controller.
 */
object VersionController {

    fun version(ctx: Context){
        ctx.json("{\"version\": \"1.0.0\"}")
    }
}
