package me.nathanfallet.groupeminaste.controllers.projects

import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.projects.ProjectLink
import me.nathanfallet.groupeminaste.models.projects.ProjectLinkPayload
import me.nathanfallet.ktorx.controllers.IChildModelController
import me.nathanfallet.ktorx.models.annotations.*

interface IProjectLinksController :
    IChildModelController<ProjectLink, String, ProjectLinkPayload, ProjectLinkPayload, Project, String> {

    @APIMapping
    @AdminTemplateMapping
    @ListModelPath
    suspend fun list(@ParentModel parent: Project): List<ProjectLink>

    @APIMapping
    @GetModelPath
    @DocumentedError(404, "projects_not_found")
    suspend fun get(call: ApplicationCall, @ParentModel parent: Project, @Id id: String): ProjectLink

    @APIMapping
    @CreateModelPath
    @AdminTemplateMapping
    @DocumentedError(401, "auth_invalid_credentials")
    @DocumentedError(500, "error_internal")
    suspend fun create(
        call: ApplicationCall,
        @ParentModel parent: Project,
        @Payload payload: ProjectLinkPayload,
    ): ProjectLink

    @APIMapping
    @UpdateModelPath
    @AdminTemplateMapping
    @DocumentedError(401, "auth_invalid_credentials")
    @DocumentedError(404, "projects_not_found")
    @DocumentedError(500, "error_internal")
    suspend fun update(
        call: ApplicationCall,
        @ParentModel parent: Project,
        @Id id: String,
        @Payload payload: ProjectLinkPayload,
    ): ProjectLink

    @APIMapping
    @DeleteModelPath
    @AdminTemplateMapping
    @DocumentedType(ProjectLink::class)
    @DocumentedError(401, "auth_invalid_credentials")
    @DocumentedError(404, "projects_not_found")
    @DocumentedError(500, "error_internal")
    suspend fun delete(call: ApplicationCall, @ParentModel parent: Project, @Id id: String)

}
