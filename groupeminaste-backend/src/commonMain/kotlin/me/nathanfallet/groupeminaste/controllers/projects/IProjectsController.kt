package me.nathanfallet.groupeminaste.controllers.projects

import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.projects.ProjectPayload
import me.nathanfallet.ktorx.controllers.IModelController
import me.nathanfallet.ktorx.models.annotations.APIMapping
import me.nathanfallet.ktorx.models.annotations.ListModelPath
import me.nathanfallet.ktorx.models.annotations.Path
import me.nathanfallet.ktorx.models.annotations.TemplateMapping

interface IProjectsController : IModelController<Project, String, ProjectPayload, ProjectPayload> {

    @APIMapping
    @ListModelPath
    suspend fun list(): List<Project>

    @TemplateMapping("public/projects/list.ftl")
    @Path("GET", "/")
    suspend fun listTemplate(): Map<String, Any>

}
