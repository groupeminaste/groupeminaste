package me.nathanfallet.groupeminaste.controllers.models

import io.ktor.server.freemarker.*
import io.ktor.util.reflect.*
import me.nathanfallet.groupeminaste.usecases.web.IGetAdminMenuForCallUseCase
import me.nathanfallet.ktorx.controllers.IChildModelController
import me.nathanfallet.ktorx.routers.IChildModelRouter
import me.nathanfallet.ktorx.routers.admin.LocalizedAdminChildModelRouter
import me.nathanfallet.ktorx.usecases.localization.IGetLocaleForCallUseCase
import me.nathanfallet.usecases.localization.ITranslateUseCase
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.annotations.PayloadKey
import kotlin.reflect.KClass

open class AdminChildModelRouter<Model : IChildModel<Id, CreatePayload, UpdatePayload, ParentId>, Id, CreatePayload : Any, UpdatePayload : Any, ParentModel : IChildModel<ParentId, *, *, *>, ParentId>(
    modelTypeInfo: TypeInfo,
    createPayloadTypeInfo: TypeInfo,
    updatePayloadTypeInfo: TypeInfo,
    controller: IChildModelController<Model, Id, CreatePayload, UpdatePayload, ParentModel, ParentId>,
    controllerClass: KClass<out IChildModelController<Model, Id, CreatePayload, UpdatePayload, ParentModel, ParentId>>,
    parentRouter: IChildModelRouter<ParentModel, ParentId, *, *, *, *>?,
    getLocaleForCallUseCase: IGetLocaleForCallUseCase,
    translateUseCase: ITranslateUseCase,
    getAdminMenuForCallUseCase: IGetAdminMenuForCallUseCase,
    route: String? = null,
    id: String? = null,
) : LocalizedAdminChildModelRouter<Model, Id, CreatePayload, UpdatePayload, ParentModel, ParentId>(
    modelTypeInfo,
    createPayloadTypeInfo,
    updatePayloadTypeInfo,
    controller,
    controllerClass,
    parentRouter,
    { template, model ->
        if (template == "root/error.ftl") respondTemplate(template, model)
        else respondTemplate(
            template, model + mapOf(
                "title" to translateUseCase(
                    getLocaleForCallUseCase(this),
                    ((model["route"] as String).takeIf { it.isNotEmpty() } ?: "dashboard").let { "admin_menu_$it" }
                ),
                "menu" to getAdminMenuForCallUseCase(this),
                "flatpickr" to ((model["keys"] as? List<*>)?.any { (it as? PayloadKey)?.type == "date" } == true),
            )
        )
    },
    getLocaleForCallUseCase,
    "root/error.ftl",
    "/auth/login?redirect={path}",
    "admin/models/list.ftl",
    null,
    "admin/models/form.ftl",
    "admin/models/form.ftl",
    "admin/models/delete.ftl",
    route,
    id,
)
