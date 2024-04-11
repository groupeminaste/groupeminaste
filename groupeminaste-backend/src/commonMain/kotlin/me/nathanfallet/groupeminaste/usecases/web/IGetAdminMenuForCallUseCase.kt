package me.nathanfallet.groupeminaste.usecases.web

import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.models.web.WebMenu
import me.nathanfallet.usecases.base.ISuspendUseCase

interface IGetAdminMenuForCallUseCase : ISuspendUseCase<ApplicationCall, List<WebMenu>>
