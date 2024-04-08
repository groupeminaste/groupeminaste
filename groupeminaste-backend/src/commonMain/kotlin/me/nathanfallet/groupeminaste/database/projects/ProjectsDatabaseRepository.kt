package me.nathanfallet.groupeminaste.database.projects

import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.repositories.projects.IProjectsRepository
import me.nathanfallet.surexposed.database.IDatabase
import me.nathanfallet.usecases.context.IContext
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll

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

}
