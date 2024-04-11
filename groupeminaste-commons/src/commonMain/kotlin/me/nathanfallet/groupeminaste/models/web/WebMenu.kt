package me.nathanfallet.groupeminaste.models.web

import kotlinx.serialization.Serializable
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.annotations.ModelProperty
import me.nathanfallet.usecases.models.annotations.Schema

@Serializable
data class WebMenu(
    @ModelProperty("id")
    @Schema("Id of the menu", "123abc")
    override val id: String,
    @ModelProperty("string")
    @Schema("Title of the menu", "Accueil")
    val title: String,
    @ModelProperty("string")
    @Schema("URL of the menu", "/")
    val url: String,
    @Schema("Position of the menu in the menu bar", "0")
    val position: Int = 0,
    @Schema("Id of the parent menu", "123abc")
    val parentMenuId: String? = null,
    @Schema("List of children menus", "[]")
    val children: List<WebMenu> = emptyList(),
) : IModel<String, Unit, Unit>
