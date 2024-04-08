package me.nathanfallet.groupeminaste.usecases.auth

import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.models.auth.SessionPayload
import me.nathanfallet.usecases.base.IUseCase

interface IGetSessionForCallUseCase : IUseCase<ApplicationCall, SessionPayload?>
