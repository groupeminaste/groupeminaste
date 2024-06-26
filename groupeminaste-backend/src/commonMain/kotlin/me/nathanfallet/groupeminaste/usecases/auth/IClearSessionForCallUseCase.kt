package me.nathanfallet.groupeminaste.usecases.auth

import io.ktor.server.application.*
import me.nathanfallet.usecases.base.IUseCase

interface IClearSessionForCallUseCase : IUseCase<ApplicationCall, Unit>
