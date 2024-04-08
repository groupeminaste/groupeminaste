package me.nathanfallet.groupeminaste.controllers.auth

import io.ktor.http.*
import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.models.auth.LoginPayload
import me.nathanfallet.groupeminaste.models.auth.SessionPayload
import me.nathanfallet.groupeminaste.usecases.auth.IClearSessionForCallUseCase
import me.nathanfallet.groupeminaste.usecases.auth.ILoginUseCase
import me.nathanfallet.groupeminaste.usecases.auth.ISetSessionForCallUseCase
import me.nathanfallet.ktorx.models.exceptions.ControllerException
import me.nathanfallet.ktorx.models.responses.RedirectResponse

class AuthController(
    private val loginUseCase: ILoginUseCase,
    private val setSessionForCallUseCase: ISetSessionForCallUseCase,
    private val clearSessionForCallUseCase: IClearSessionForCallUseCase,
) : IAuthController {

    override fun login() {}

    override suspend fun login(call: ApplicationCall, payload: LoginPayload, redirect: String?): RedirectResponse {
        val user = loginUseCase(payload) ?: throw ControllerException(
            HttpStatusCode.Unauthorized, "auth_invalid_credentials"
        )
        setSessionForCallUseCase(call, SessionPayload(user.id))
        return RedirectResponse(redirect ?: "/")
    }

    override suspend fun logout(call: ApplicationCall, redirect: String?): RedirectResponse {
        clearSessionForCallUseCase(call)
        return RedirectResponse(redirect ?: "/")
    }

}
