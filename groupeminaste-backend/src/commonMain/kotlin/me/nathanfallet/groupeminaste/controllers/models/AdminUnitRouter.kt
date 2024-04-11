package me.nathanfallet.groupeminaste.controllers.models

import io.ktor.util.reflect.*
import me.nathanfallet.groupeminaste.usecases.web.IGetAdminMenuForCallUseCase
import me.nathanfallet.ktorx.controllers.IUnitController
import me.nathanfallet.ktorx.routers.IUnitRouter
import me.nathanfallet.ktorx.usecases.localization.IGetLocaleForCallUseCase
import me.nathanfallet.usecases.localization.ITranslateUseCase
import me.nathanfallet.usecases.models.UnitModel
import kotlin.reflect.KClass

open class AdminUnitRouter(
    controller: IUnitController,
    controllerClass: KClass<out IUnitController>,
    getLocaleForCallUseCase: IGetLocaleForCallUseCase,
    translateUseCase: ITranslateUseCase,
    getAdminMenuForCallUseCase: IGetAdminMenuForCallUseCase,
    route: String? = null,
) : AdminModelRouter<UnitModel, Unit, Unit, Unit>(
    typeInfo<UnitModel>(),
    typeInfo<Unit>(),
    typeInfo<Unit>(),
    controller,
    controllerClass,
    getLocaleForCallUseCase,
    translateUseCase,
    getAdminMenuForCallUseCase,
    route ?: "",
), IUnitRouter
