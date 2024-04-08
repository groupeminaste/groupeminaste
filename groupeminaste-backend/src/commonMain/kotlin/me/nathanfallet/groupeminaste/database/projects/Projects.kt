package me.nathanfallet.groupeminaste.database.projects

import kotlinx.datetime.toInstant
import me.nathanfallet.groupeminaste.database.users.Users
import me.nathanfallet.groupeminaste.extensions.generateId
import me.nathanfallet.groupeminaste.models.projects.Project
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll

object Projects : Table() {

    val id = varchar("id", 32)
    val name = varchar("name", 255)
    val description = text("description")
    val image = varchar("image", 255)
    val category = varchar("category", 255)
    val updatedAt = varchar("updated_at", 255)

    override val primaryKey = PrimaryKey(Users.id)

    fun generateId(): String {
        val candidate = String.generateId()
        return if (selectAll().where { id eq candidate }.count() > 0) generateId() else candidate
    }

    fun toProject(
        row: ResultRow,
    ) = Project(
        row[id],
        row[name],
        row[description],
        row[image],
        row[category],
        row[updatedAt].toInstant()
    )

}
