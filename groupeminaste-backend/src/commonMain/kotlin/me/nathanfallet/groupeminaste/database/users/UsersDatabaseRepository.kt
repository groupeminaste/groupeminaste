package me.nathanfallet.groupeminaste.database.users

import me.nathanfallet.groupeminaste.models.users.User
import me.nathanfallet.groupeminaste.repositories.users.IUsersRepository
import me.nathanfallet.surexposed.database.IDatabase
import me.nathanfallet.usecases.context.IContext
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll

class UsersDatabaseRepository(
    private val database: IDatabase,
) : IUsersRepository {

    init {
        database.transaction {
            SchemaUtils.create(Users)
        }
    }

    override suspend fun list(context: IContext?): List<User> =
        database.suspendedTransaction {
            Users
                .selectAll()
                .map(Users::toUser)
        }

    override suspend fun get(id: String, context: IContext?): User? =
        database.suspendedTransaction {
            Users
                .selectAll()
                .where { Users.id eq id }
                .map(Users::toUser)
                .singleOrNull()
        }

    override suspend fun getForEmail(email: String, includePassword: Boolean): User? =
        database.suspendedTransaction {
            Users
                .selectAll()
                .where { Users.email eq email }
                .map {
                    Users.toUser(it, includePassword)
                }
                .singleOrNull()
        }

}
