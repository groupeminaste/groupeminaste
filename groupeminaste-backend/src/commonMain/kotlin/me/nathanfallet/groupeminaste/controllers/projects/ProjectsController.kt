package me.nathanfallet.groupeminaste.controllers.projects

import io.ktor.http.*
import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.projects.ProjectLink
import me.nathanfallet.groupeminaste.models.projects.ProjectPayload
import me.nathanfallet.ktorx.models.exceptions.ControllerException
import me.nathanfallet.ktorx.usecases.users.IRequireUserForCallUseCase
import me.nathanfallet.usecases.models.create.ICreateModelSuspendUseCase
import me.nathanfallet.usecases.models.delete.IDeleteModelSuspendUseCase
import me.nathanfallet.usecases.models.get.IGetModelSuspendUseCase
import me.nathanfallet.usecases.models.list.IListChildModelSuspendUseCase
import me.nathanfallet.usecases.models.list.IListModelSuspendUseCase
import me.nathanfallet.usecases.models.update.IUpdateModelSuspendUseCase

class ProjectsController(
    private val requireUserForCallUseCase: IRequireUserForCallUseCase,
    private val listProjectsUseCase: IListModelSuspendUseCase<Project>,
    private val getProjectUseCase: IGetModelSuspendUseCase<Project, String>,
    private val createProjectUseCase: ICreateModelSuspendUseCase<Project, ProjectPayload>,
    private val updateProjectUseCase: IUpdateModelSuspendUseCase<Project, String, ProjectPayload>,
    private val deleteProjectUseCase: IDeleteModelSuspendUseCase<Project, String>,
    private val listProjectLinksUseCase: IListChildModelSuspendUseCase<ProjectLink, String>,
) : IProjectsController {

    override suspend fun list(): List<Project> {
        return listProjectsUseCase()
    }

    override suspend fun listTemplate(): Map<String, Any> {
        val projects = listProjectsUseCase()
        return mapOf(
            "projects" to projects,
            "projectsCategories" to projects.map { it.category }.distinct()
        )
    }

    override suspend fun get(call: ApplicationCall, id: String): Project {
        return getProjectUseCase(id) ?: throw ControllerException(
            HttpStatusCode.NotFound, "projects_not_found"
        )
    }

    override suspend fun details(call: ApplicationCall, id: String): Map<String, Any> {
        val project = getProjectUseCase(id) ?: throw ControllerException(
            HttpStatusCode.NotFound, "projects_not_found"
        )
        return mapOf(
            "item" to project,
            "links" to listProjectLinksUseCase(id)
        )
    }

    override suspend fun create(call: ApplicationCall, payload: ProjectPayload): Project {
        requireUserForCallUseCase(call)
        return createProjectUseCase(payload) ?: throw ControllerException(
            HttpStatusCode.InternalServerError, "error_internal"
        )
    }

    override suspend fun update(call: ApplicationCall, id: String, payload: ProjectPayload): Project {
        requireUserForCallUseCase(call)
        val project = getProjectUseCase(id) ?: throw ControllerException(
            HttpStatusCode.NotFound, "projects_not_found"
        )
        return updateProjectUseCase(project.id, payload) ?: throw ControllerException(
            HttpStatusCode.InternalServerError, "error_internal"
        )
    }

    override suspend fun delete(call: ApplicationCall, id: String) {
        requireUserForCallUseCase(call)
        val project = getProjectUseCase(id) ?: throw ControllerException(
            HttpStatusCode.NotFound, "projects_not_found"
        )
        if (!deleteProjectUseCase(project.id)) throw ControllerException(
            HttpStatusCode.InternalServerError, "error_internal"
        )
    }

}
