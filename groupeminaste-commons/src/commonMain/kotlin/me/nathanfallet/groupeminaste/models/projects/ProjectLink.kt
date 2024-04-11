package me.nathanfallet.groupeminaste.models.projects

import kotlinx.serialization.Serializable
import me.nathanfallet.usecases.models.IChildModel
import me.nathanfallet.usecases.models.annotations.ModelProperty
import me.nathanfallet.usecases.models.annotations.Schema

@Serializable
data class ProjectLink(
    @ModelProperty("id")
    @Schema("Id of the Link", "123abc")
    override val id: String,
    @Schema("If of the project the link belongs to", "123abc")
    val projectId: String,
    @ModelProperty("string")
    @Schema("Name of the link", "App Store")
    val name: String,
    @ModelProperty("url")
    @Schema("URL of the link", "https://...")
    val url: String,
) : IChildModel<String, ProjectLinkPayload, ProjectLinkPayload, String> {

    override val parentId: String
        get() = projectId

}
