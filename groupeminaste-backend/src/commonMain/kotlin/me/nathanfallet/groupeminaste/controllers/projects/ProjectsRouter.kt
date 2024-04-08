package me.nathanfallet.groupeminaste.controllers.projects

import io.ktor.server.freemarker.*
import io.ktor.util.reflect.*
import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.projects.ProjectPayload
import me.nathanfallet.ktorx.routers.api.APIModelRouter
import me.nathanfallet.ktorx.routers.concat.ConcatModelRouter
import me.nathanfallet.ktorx.routers.templates.LocalizedTemplateModelRouter
import me.nathanfallet.ktorx.usecases.localization.IGetLocaleForCallUseCase

class ProjectsRouter(
    controller: IProjectsController,
    getLocaleForCallUseCase: IGetLocaleForCallUseCase,
) : ConcatModelRouter<Project, String, ProjectPayload, ProjectPayload>(
    APIModelRouter(
        typeInfo<Project>(),
        typeInfo<ProjectPayload>(),
        typeInfo<ProjectPayload>(),
        controller,
        IProjectsController::class,
        prefix = "/api/v1"
    ),
    LocalizedTemplateModelRouter(
        typeInfo<Project>(),
        typeInfo<ProjectPayload>(),
        typeInfo<ProjectPayload>(),
        controller,
        IProjectsController::class,
        { template, model ->
            respondTemplate(template, model)
        },
        getLocaleForCallUseCase
    )
)
