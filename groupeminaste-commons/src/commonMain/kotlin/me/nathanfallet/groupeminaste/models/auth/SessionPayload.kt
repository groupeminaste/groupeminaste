package me.nathanfallet.groupeminaste.models.auth

import kotlinx.serialization.Serializable
import me.nathanfallet.usecases.auth.ISessionPayload

@Serializable
data class SessionPayload(
    val userId: String,
) : ISessionPayload
