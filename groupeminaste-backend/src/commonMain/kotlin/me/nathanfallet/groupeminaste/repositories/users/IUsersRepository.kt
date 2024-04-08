package me.nathanfallet.groupeminaste.repositories.users

import me.nathanfallet.groupeminaste.models.users.User
import me.nathanfallet.usecases.models.repositories.IModelSuspendRepository

interface IUsersRepository : IModelSuspendRepository<User, String, Unit, Unit> {

    suspend fun getForEmail(email: String, includePassword: Boolean): User?

}
