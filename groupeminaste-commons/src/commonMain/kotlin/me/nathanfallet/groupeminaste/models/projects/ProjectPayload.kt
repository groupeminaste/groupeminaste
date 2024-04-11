package me.nathanfallet.groupeminaste.models.projects

import kotlinx.serialization.Serializable
import me.nathanfallet.usecases.models.annotations.PayloadProperty
import me.nathanfallet.usecases.models.annotations.Schema

@Serializable
data class ProjectPayload(
    @PayloadProperty("string")
    @Schema("Name of the Project", "Extopy")
    val name: String,
    @PayloadProperty("string")
    @Schema("Description of the Project", "A social network")
    val description: String,
    @PayloadProperty("string")
    @Schema("Image of the Project", "https://...")
    val image: String,
    @PayloadProperty("string")
    @Schema("Category of the Project", "App")
    val category: String,
)
