package me.nathanfallet.groupeminaste.controllers.files

import me.nathanfallet.groupeminaste.controllers.models.AdminUnitRouter
import me.nathanfallet.groupeminaste.usecases.web.IGetAdminMenuForCallUseCase
import me.nathanfallet.ktorx.usecases.localization.IGetLocaleForCallUseCase
import me.nathanfallet.usecases.localization.ITranslateUseCase

class FilesRouter(
    controller: IFilesController,
    getLocaleForCallUseCase: IGetLocaleForCallUseCase,
    translateUseCase: ITranslateUseCase,
    getAdminMenuForCallUseCase: IGetAdminMenuForCallUseCase,
) : AdminUnitRouter(
    controller,
    IFilesController::class,
    getLocaleForCallUseCase,
    translateUseCase,
    getAdminMenuForCallUseCase,
    route = "files"
)

