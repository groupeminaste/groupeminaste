package me.nathanfallet.groupeminaste.models.projects

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.annotations.Schema

@Serializable
data class Project(
    @Schema("Id of the Project", "123abc")
    override val id: String,
    @Schema("Name of the Project", "Extopy")
    val name: String,
    @Schema("Description of the Project", "A social network")
    val description: String,
    @Schema("Image of the Project", "https://...")
    val image: String,
    @Schema("Category of the Project", "App")
    val category: String,
    @Schema("Updated date of the Project", "2023-12-13T09:41:00Z")
    val updatedAt: Instant,
) : IModel<String, ProjectPayload, ProjectPayload>
