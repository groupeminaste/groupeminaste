package me.nathanfallet.groupeminaste.plugins

import io.ktor.server.application.*
import io.ktor.server.sessions.*
import me.nathanfallet.groupeminaste.models.auth.SessionPayload
import me.nathanfallet.ktorx.repositories.sessions.ISessionsRepository
import org.koin.ktor.ext.inject

fun Application.configureSessions() {
    val sessionsRepository by inject<ISessionsRepository>()

    install(Sessions) {
        cookie<SessionPayload>("session", sessionsRepository) {
            cookie.path = "/"
        }
    }
}
