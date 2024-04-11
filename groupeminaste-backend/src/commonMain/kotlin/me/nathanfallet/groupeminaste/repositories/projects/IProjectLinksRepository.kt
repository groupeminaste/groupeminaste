package me.nathanfallet.groupeminaste.repositories.projects

import me.nathanfallet.groupeminaste.models.projects.ProjectLink
import me.nathanfallet.groupeminaste.models.projects.ProjectLinkPayload
import me.nathanfallet.usecases.models.repositories.IChildModelSuspendRepository

interface IProjectLinksRepository :
    IChildModelSuspendRepository<ProjectLink, String, ProjectLinkPayload, ProjectLinkPayload, String>
