package me.nathanfallet.groupeminaste.models.projects

import kotlinx.serialization.Serializable
import me.nathanfallet.usecases.models.annotations.Schema

@Serializable
data class ProjectPayload(
    @Schema("Name of the Project", "Extopy")
    val name: String,
    @Schema("Description of the Project", "A social network")
    val description: String,
    @Schema("Image of the Project", "https://...")
    val image: String,
    @Schema("Category of the Project", "App")
    val category: String,
)
