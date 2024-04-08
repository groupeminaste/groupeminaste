package me.nathanfallet.groupeminaste.controllers.auth

import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.models.auth.LoginPayload
import me.nathanfallet.ktorx.controllers.IUnitController
import me.nathanfallet.ktorx.models.annotations.Path
import me.nathanfallet.ktorx.models.annotations.Payload
import me.nathanfallet.ktorx.models.annotations.QueryParameter
import me.nathanfallet.ktorx.models.annotations.TemplateMapping
import me.nathanfallet.ktorx.models.responses.RedirectResponse

interface IAuthController : IUnitController {

    @TemplateMapping("auth/login.ftl")
    @Path("GET", "/login")
    fun login()

    @TemplateMapping("auth/login.ftl")
    @Path("POST", "/login")
    suspend fun login(
        call: ApplicationCall,
        @Payload payload: LoginPayload,
        @QueryParameter redirect: String?,
    ): RedirectResponse

    @TemplateMapping("auth/login.ftl")
    @Path("GET", "/logout")
    suspend fun logout(call: ApplicationCall, @QueryParameter redirect: String?): RedirectResponse

}
