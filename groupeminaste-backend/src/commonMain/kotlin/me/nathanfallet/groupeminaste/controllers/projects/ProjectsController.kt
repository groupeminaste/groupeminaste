package me.nathanfallet.groupeminaste.controllers.projects

import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.usecases.models.list.IListModelSuspendUseCase

class ProjectsController(
    private val listProjectsUseCase: IListModelSuspendUseCase<Project>,
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

}
