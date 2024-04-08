package me.nathanfallet.groupeminaste.usecases.auth

import me.nathanfallet.usecases.base.IPairUseCase

interface IVerifyPasswordUseCase : IPairUseCase<String, String, Boolean>
