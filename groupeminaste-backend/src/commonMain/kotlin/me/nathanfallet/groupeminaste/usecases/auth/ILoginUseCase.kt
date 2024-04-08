package me.nathanfallet.groupeminaste.usecases.auth

import me.nathanfallet.groupeminaste.models.auth.LoginPayload
import me.nathanfallet.groupeminaste.models.users.User
import me.nathanfallet.usecases.base.ISuspendUseCase

interface ILoginUseCase : ISuspendUseCase<LoginPayload, User?>
