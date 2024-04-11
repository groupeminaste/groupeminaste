package me.nathanfallet.groupeminaste.controllers.projects

import io.ktor.http.*
import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.projects.ProjectLink
import me.nathanfallet.groupeminaste.models.projects.ProjectLinkPayload
import me.nathanfallet.ktorx.models.exceptions.ControllerException
import me.nathanfallet.ktorx.usecases.users.IRequireUserForCallUseCase
import me.nathanfallet.usecases.models.create.ICreateChildModelSuspendUseCase
import me.nathanfallet.usecases.models.delete.IDeleteChildModelSuspendUseCase
import me.nathanfallet.usecases.models.get.IGetChildModelSuspendUseCase
import me.nathanfallet.usecases.models.list.IListChildModelSuspendUseCase
import me.nathanfallet.usecases.models.update.IUpdateChildModelSuspendUseCase

class ProjectLinksController(
    private val requireUserForCallUseCase: IRequireUserForCallUseCase,
    private val listProjectLinksUseCase: IListChildModelSuspendUseCase<ProjectLink, String>,
    private val getProjectLinkUseCase: IGetChildModelSuspendUseCase<ProjectLink, String, String>,
    private val createProjectLinkUseCase: ICreateChildModelSuspendUseCase<ProjectLink, ProjectLinkPayload, String>,
    private val updateProjectLinkUseCase: IUpdateChildModelSuspendUseCase<ProjectLink, String, ProjectLinkPayload, String>,
    private val deleteProjectLinkUseCase: IDeleteChildModelSuspendUseCase<ProjectLink, String, String>,
) : IProjectLinksController {

    override suspend fun list(parent: Project): List<ProjectLink> {
        return listProjectLinksUseCase(parent.id)
    }

    override suspend fun get(call: ApplicationCall, parent: Project, id: String): ProjectLink {
        return getProjectLinkUseCase(id, parent.id) ?: throw ControllerException(
            HttpStatusCode.NotFound, "projects_not_found"
        )
    }

    override suspend fun create(call: ApplicationCall, parent: Project, payload: ProjectLinkPayload): ProjectLink {
        requireUserForCallUseCase(call)
        return createProjectLinkUseCase(payload, parent.id) ?: throw ControllerException(
            HttpStatusCode.InternalServerError, "error_internal"
        )
    }

    override suspend fun update(
        call: ApplicationCall,
        parent: Project,
        id: String,
        payload: ProjectLinkPayload,
    ): ProjectLink {
        requireUserForCallUseCase(call)
        val link = getProjectLinkUseCase(id, parent.id) ?: throw ControllerException(
            HttpStatusCode.NotFound, "projects_not_found"
        )
        return updateProjectLinkUseCase(link.id, payload, parent.id) ?: throw ControllerException(
            HttpStatusCode.InternalServerError, "error_internal"
        )
    }

    override suspend fun delete(call: ApplicationCall, parent: Project, id: String) {
        requireUserForCallUseCase(call)
        val link = getProjectLinkUseCase(id, parent.id) ?: throw ControllerException(
            HttpStatusCode.NotFound, "projects_not_found"
        )
        if (!deleteProjectLinkUseCase(link.id, parent.id)) throw ControllerException(
            HttpStatusCode.InternalServerError, "error_internal"
        )
    }

}
