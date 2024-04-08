package me.nathanfallet.groupeminaste.controllers.web

import io.ktor.server.freemarker.*
import me.nathanfallet.ktorx.routers.templates.LocalizedTemplateUnitRouter
import me.nathanfallet.ktorx.usecases.localization.IGetLocaleForCallUseCase

class WebRouter(
    controller: IWebController,
    getLocaleForCallUseCase: IGetLocaleForCallUseCase,
) : LocalizedTemplateUnitRouter(
    controller,
    IWebController::class,
    { template, model ->
        respondTemplate(template, model)
    },
    getLocaleForCallUseCase
)
