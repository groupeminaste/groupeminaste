package me.nathanfallet.groupeminaste.database.projects

import kotlinx.datetime.Clock
import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.projects.ProjectPayload
import me.nathanfallet.groupeminaste.repositories.projects.IProjectsRepository
import me.nathanfallet.surexposed.database.IDatabase
import me.nathanfallet.usecases.context.IContext
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class ProjectsDatabaseRepository(
    private val database: IDatabase,
) : IProjectsRepository {

    init {
        database.transaction {
            SchemaUtils.create(Projects)
        }
    }

    override suspend fun list(context: IContext?): List<Project> =
        database.transaction {
            Projects
                .selectAll()
                .map(Projects::toProject)
        }

    override suspend fun get(id: String, context: IContext?): Project? =
        database.transaction {
            Projects
                .selectAll()
                .where { Projects.id eq id }
                .map(Projects::toProject)
                .singleOrNull()
        }

    override suspend fun create(payload: ProjectPayload, context: IContext?): Project? =
        database.transaction {
            Projects.insert {
                it[id] = generateId()
                it[name] = payload.name
                it[description] = payload.description
                it[category] = payload.category
                it[image] = payload.image
                it[updatedAt] = Clock.System.now().toString()
            }.resultedValues?.map(Projects::toProject)?.singleOrNull()
        }

    override suspend fun update(id: String, payload: ProjectPayload, context: IContext?): Boolean =
        database.transaction {
            Projects.update({ Projects.id eq id }) {
                it[name] = payload.name
                it[description] = payload.description
                it[category] = payload.category
                it[image] = payload.image
                it[updatedAt] = Clock.System.now().toString()
            }
        } == 1

    override suspend fun delete(id: String, context: IContext?): Boolean =
        database.transaction {
            Projects.deleteWhere { Projects.id eq id }
        } == 1

}
