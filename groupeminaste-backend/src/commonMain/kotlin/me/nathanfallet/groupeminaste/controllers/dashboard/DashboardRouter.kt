package me.nathanfallet.groupeminaste.controllers.dashboard

import me.nathanfallet.groupeminaste.controllers.models.AdminUnitRouter
import me.nathanfallet.groupeminaste.usecases.web.IGetAdminMenuForCallUseCase
import me.nathanfallet.ktorx.usecases.localization.IGetLocaleForCallUseCase
import me.nathanfallet.usecases.localization.ITranslateUseCase

class DashboardRouter(
    controller: IDashboardController,
    getLocaleForCallUseCase: IGetLocaleForCallUseCase,
    translateUseCase: ITranslateUseCase,
    getAdminMenuForCallUseCase: IGetAdminMenuForCallUseCase,
) : AdminUnitRouter(
    controller,
    IDashboardController::class,
    getLocaleForCallUseCase,
    translateUseCase,
    getAdminMenuForCallUseCase
)
