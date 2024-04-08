package me.nathanfallet.groupeminaste.repositories.projects

import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.projects.ProjectPayload
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

interface IProjectsRepository : IModelSuspendRepository<Project, String, ProjectPayload, ProjectPayload>
