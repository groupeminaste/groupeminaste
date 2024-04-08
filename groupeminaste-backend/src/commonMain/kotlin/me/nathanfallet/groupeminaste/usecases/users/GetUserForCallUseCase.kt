package me.nathanfallet.groupeminaste.usecases.users

import io.ktor.server.application.*
import io.ktor.util.*
import me.nathanfallet.groupeminaste.models.users.User
import me.nathanfallet.groupeminaste.usecases.auth.IGetJWTPrincipalForCallUseCase
import me.nathanfallet.groupeminaste.usecases.auth.IGetSessionForCallUseCase
import me.nathanfallet.ktorx.usecases.users.IGetUserForCallUseCase
import me.nathanfallet.usecases.models.get.IGetModelSuspendUseCase
import me.nathanfallet.usecases.users.IUser

class GetUserForCallUseCase(
    private val getJWTPrincipalForCall: IGetJWTPrincipalForCallUseCase,
    private val getSessionForCallUseCase: IGetSessionForCallUseCase,
    private val getUserUseCase: IGetModelSuspendUseCase<User, String>,
) : IGetUserForCallUseCase {

    private data class UserForCall(
        val user: User?,
    )

    private val userKey = AttributeKey<UserForCall>("extopy-user")

    override suspend fun invoke(input: ApplicationCall): IUser? {
        // Note: we cannot use `computeIfAbsent` because it does not support suspending functions
        return input.attributes.getOrNull(userKey)?.user ?: run {
            val id = getJWTPrincipalForCall(input)?.subject ?: getSessionForCallUseCase(input)?.userId
            val computed = UserForCall(id?.let { getUserUseCase(it) })
            input.attributes.put(userKey, computed)
            computed.user
        }
    }

}
