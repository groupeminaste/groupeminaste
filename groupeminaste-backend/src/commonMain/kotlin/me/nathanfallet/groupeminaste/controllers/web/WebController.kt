package me.nathanfallet.groupeminaste.controllers.web

import me.nathanfallet.groupeminaste.models.application.GetInTouchPayload
import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.users.User
import me.nathanfallet.groupeminaste.usecases.application.IGetInTouchUseCase
import me.nathanfallet.ktorx.models.responses.RedirectResponse
import me.nathanfallet.usecases.models.list.IListModelSuspendUseCase

class WebController(
    private val listUsersUseCase: IListModelSuspendUseCase<User>,
    private val listProjectsUseCase: IListModelSuspendUseCase<Project>,
    private val getInTouchUseCase: IGetInTouchUseCase,
) : IWebController {

    override suspend fun home(): Map<String, Any> {
        val projects = listProjectsUseCase()
        return mapOf(
            "users" to listUsersUseCase(),
            "projects" to projects,
            "projectsCategories" to projects.map { it.category }.distinct()
        )
    }

    override suspend fun mentionsLegales() {}

    override fun discord() = RedirectResponse(
        "https://discord.gg/PeTpuCWnqs", true
    )

    override suspend fun getInTouch(payload: GetInTouchPayload) = getInTouchUseCase(payload)

    override suspend fun infos(file: String) = RedirectResponse(
        "https://cdn.groupe-minaste.org/$file", true
    )

}
