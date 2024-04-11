package me.nathanfallet.groupeminaste.models.projects

import kotlinx.serialization.Serializable
import me.nathanfallet.usecases.models.annotations.PayloadProperty
import me.nathanfallet.usecases.models.annotations.Schema

@Serializable
data class ProjectLinkPayload(
    @PayloadProperty("string")
    @Schema("Name of the link", "App Store")
    val name: String,
    @PayloadProperty("url")
    @Schema("URL of the link", "https://...")
    val url: String,
)
