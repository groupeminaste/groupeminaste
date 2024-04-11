package me.nathanfallet.groupeminaste.database.projects

import me.nathanfallet.groupeminaste.database.users.Users
import me.nathanfallet.groupeminaste.extensions.generateId
import me.nathanfallet.groupeminaste.models.projects.ProjectLink
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll

object ProjectLinks : Table() {

    val id = varchar("id", 32)
    val projectId = varchar("project_id", 32).index()
    val name = varchar("name", 255)
    val url = text("url")

    override val primaryKey = PrimaryKey(Users.id)

    fun generateId(): String {
        val candidate = String.generateId()
        return if (selectAll().where { id eq candidate }.count() > 0) generateId() else candidate
    }

    fun toProjectLink(
        row: ResultRow,
    ) = ProjectLink(
        row[id],
        row[projectId],
        row[name],
        row[url]
    )

}
