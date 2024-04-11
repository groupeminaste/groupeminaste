package me.nathanfallet.groupeminaste.controllers.projects

import io.ktor.util.reflect.*
import me.nathanfallet.groupeminaste.controllers.models.AdminChildModelRouter
import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.projects.ProjectLink
import me.nathanfallet.groupeminaste.models.projects.ProjectLinkPayload
import me.nathanfallet.groupeminaste.usecases.web.IGetAdminMenuForCallUseCase
import me.nathanfallet.ktorx.routers.api.APIChildModelRouter
import me.nathanfallet.ktorx.routers.concat.ConcatChildModelRouter
import me.nathanfallet.ktorx.usecases.localization.IGetLocaleForCallUseCase
import me.nathanfallet.usecases.localization.ITranslateUseCase

class ProjectLinksRouter(
    controller: IProjectLinksController,
    getLocaleForCallUseCase: IGetLocaleForCallUseCase,
    translateUseCase: ITranslateUseCase,
    getAdminMenuForCallUseCase: IGetAdminMenuForCallUseCase,
    projectsRouter: ProjectsRouter,
) : ConcatChildModelRouter<ProjectLink, String, ProjectLinkPayload, ProjectLinkPayload, Project, String>(
    APIChildModelRouter(
        typeInfo<ProjectLink>(),
        typeInfo<ProjectLinkPayload>(),
        typeInfo<ProjectLinkPayload>(),
        controller,
        IProjectLinksController::class,
        projectsRouter,
        prefix = "/api/v1",
        route = "links"
    ),
    AdminChildModelRouter(
        typeInfo<ProjectLink>(),
        typeInfo<ProjectLinkPayload>(),
        typeInfo<ProjectLinkPayload>(),
        controller,
        IProjectLinksController::class,
        projectsRouter,
        getLocaleForCallUseCase,
        translateUseCase,
        getAdminMenuForCallUseCase,
        route = "links"
    )
)
