package me.nathanfallet.groupeminaste.controllers.projects

import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.projects.ProjectPayload
import me.nathanfallet.ktorx.controllers.IModelController
import me.nathanfallet.ktorx.models.annotations.*

interface IProjectsController : IModelController<Project, String, ProjectPayload, ProjectPayload> {

    @APIMapping
    @AdminTemplateMapping
    @ListModelPath
    suspend fun list(): List<Project>

    @TemplateMapping("public/projects/list.ftl")
    @Path("GET", "/")
    suspend fun listTemplate(): Map<String, Any>

    @APIMapping
    @GetModelPath
    @DocumentedError(404, "projects_not_found")
    suspend fun get(call: ApplicationCall, @Id id: String): Project

    @TemplateMapping("public/projects/details.ftl")
    @Path("GET", "/{projectId}")
    suspend fun details(call: ApplicationCall, @Id id: String): Map<String, Any>

    @APIMapping
    @CreateModelPath
    @AdminTemplateMapping
    @DocumentedError(401, "auth_invalid_credentials")
    @DocumentedError(500, "error_internal")
    suspend fun create(call: ApplicationCall, @Payload payload: ProjectPayload): Project

    @APIMapping
    @UpdateModelPath
    @AdminTemplateMapping
    @DocumentedError(401, "auth_invalid_credentials")
    @DocumentedError(404, "projects_not_found")
    @DocumentedError(500, "error_internal")
    suspend fun update(call: ApplicationCall, @Id id: String, @Payload payload: ProjectPayload): Project

    @APIMapping
    @DeleteModelPath
    @AdminTemplateMapping
    @DocumentedType(Project::class)
    @DocumentedError(401, "auth_invalid_credentials")
    @DocumentedError(404, "projects_not_found")
    @DocumentedError(500, "error_internal")
    suspend fun delete(call: ApplicationCall, @Id id: String)

}
