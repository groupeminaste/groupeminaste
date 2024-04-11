package me.nathanfallet.groupeminaste.database.projects

import me.nathanfallet.groupeminaste.models.projects.ProjectLink
import me.nathanfallet.groupeminaste.models.projects.ProjectLinkPayload
import me.nathanfallet.groupeminaste.repositories.projects.IProjectLinksRepository
import me.nathanfallet.surexposed.database.IDatabase
import me.nathanfallet.usecases.context.IContext
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class ProjectLinksDatabaseRepository(
    private val database: IDatabase,
) : IProjectLinksRepository {

    init {
        database.transaction {
            SchemaUtils.create(ProjectLinks)
        }
    }

    override suspend fun list(parentId: String, context: IContext?): List<ProjectLink> =
        database.transaction {
            ProjectLinks
                .selectAll()
                .where { ProjectLinks.projectId eq parentId }
                .map(ProjectLinks::toProjectLink)
        }

    override suspend fun get(id: String, parentId: String, context: IContext?): ProjectLink? =
        database.transaction {
            ProjectLinks
                .selectAll()
                .where { ProjectLinks.id eq id and (ProjectLinks.projectId eq parentId) }
                .map(ProjectLinks::toProjectLink)
                .singleOrNull()
        }

    override suspend fun create(payload: ProjectLinkPayload, parentId: String, context: IContext?): ProjectLink? =
        database.transaction {
            ProjectLinks.insert {
                it[id] = generateId()
                it[projectId] = parentId
                it[name] = payload.name
                it[url] = payload.url
            }.resultedValues?.map(ProjectLinks::toProjectLink)?.singleOrNull()
        }

    override suspend fun update(
        id: String,
        payload: ProjectLinkPayload,
        parentId: String,
        context: IContext?,
    ): Boolean =
        database.transaction {
            ProjectLinks.update({ ProjectLinks.id eq id and (ProjectLinks.projectId eq parentId) }) {
                it[name] = payload.name
                it[url] = payload.url
            }
        } == 1

    override suspend fun delete(id: String, parentId: String, context: IContext?): Boolean =
        database.transaction {
            ProjectLinks.deleteWhere { ProjectLinks.id eq id and (projectId eq parentId) }
        } == 1

}
