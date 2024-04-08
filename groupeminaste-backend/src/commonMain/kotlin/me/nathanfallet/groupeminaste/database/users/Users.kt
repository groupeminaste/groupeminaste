package me.nathanfallet.groupeminaste.database.users

import me.nathanfallet.groupeminaste.extensions.generateId
import me.nathanfallet.groupeminaste.models.users.User
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll

object Users : Table() {

    val id = varchar("id", 32)
    val name = varchar("name", 255)
    val email = varchar("email", 255)
    val password = varchar("password", 255)
    val biography = text("biography")
    val avatar = varchar("avatar", 255).default("https://groupe-minaste.org/img/avatar.png")
    val website = varchar("website", 255).nullable()

    override val primaryKey = PrimaryKey(id)

    fun generateId(): String {
        val candidate = String.generateId()
        return if (selectAll().where { id eq candidate }.count() > 0) generateId() else candidate
    }

    fun toUser(
        row: ResultRow,
        includePassword: Boolean = false,
    ) = User(
        row[id],
        row[name],
        row.getOrNull(email),
        row.getOrNull(password).takeIf { includePassword },
        row.getOrNull(biography),
        row.getOrNull(avatar),
        row.getOrNull(website)
    )

}
