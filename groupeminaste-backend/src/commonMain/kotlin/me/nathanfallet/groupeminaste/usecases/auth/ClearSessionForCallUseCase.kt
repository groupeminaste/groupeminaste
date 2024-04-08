package me.nathanfallet.groupeminaste.usecases.auth

import io.ktor.server.application.*
import io.ktor.server.sessions.*
import me.nathanfallet.groupeminaste.models.auth.SessionPayload

class ClearSessionForCallUseCase : IClearSessionForCallUseCase {

    override fun invoke(input: ApplicationCall) = input.sessions.clear<SessionPayload>()

}
