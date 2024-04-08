package me.nathanfallet.groupeminaste.usecases.auth

import io.ktor.server.application.*
import io.ktor.server.sessions.*
import me.nathanfallet.groupeminaste.models.auth.SessionPayload

class GetSessionForCallUseCase : IGetSessionForCallUseCase {

    override fun invoke(input: ApplicationCall): SessionPayload? = input.sessions.get()

}
