package me.nathanfallet.groupeminaste.usecases.auth

import me.nathanfallet.groupeminaste.models.auth.LoginPayload
import me.nathanfallet.groupeminaste.models.users.User
import me.nathanfallet.groupeminaste.repositories.users.IUsersRepository

class LoginUseCase(
    private val repository: IUsersRepository,
    private val verifyPasswordUseCase: IVerifyPasswordUseCase,
) : ILoginUseCase {

    override suspend fun invoke(input: LoginPayload): User? =
        repository.getForEmail(input.email, true)?.takeIf {
            verifyPasswordUseCase(input.password, it.password ?: "")
        }

}
