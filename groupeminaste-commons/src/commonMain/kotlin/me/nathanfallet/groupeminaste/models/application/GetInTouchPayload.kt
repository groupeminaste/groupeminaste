package me.nathanfallet.groupeminaste.models.application

import kotlinx.serialization.Serializable

@Serializable
data class GetInTouchPayload(
    val name: String,
    val email: String,
    val message: String,
)
