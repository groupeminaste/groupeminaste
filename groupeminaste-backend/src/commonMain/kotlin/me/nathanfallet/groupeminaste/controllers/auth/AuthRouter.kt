package me.nathanfallet.groupeminaste.controllers.auth

import io.ktor.server.freemarker.*
import me.nathanfallet.ktorx.routers.templates.LocalizedTemplateUnitRouter
import me.nathanfallet.ktorx.usecases.localization.IGetLocaleForCallUseCase

class AuthRouter(
    controller: IAuthController,
    getLocaleForCallUseCase: IGetLocaleForCallUseCase,
) : LocalizedTemplateUnitRouter(
    controller,
    IAuthController::class,
    { template, model -> respondTemplate(template, model) },
    getLocaleForCallUseCase,
    errorTemplate = null,
    redirectUnauthorizedToUrl = "/auth/login?redirect={path}",
    route = "auth",
)
