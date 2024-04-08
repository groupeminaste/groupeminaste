package me.nathanfallet.groupeminaste.controllers.web

import me.nathanfallet.ktorx.controllers.IUnitController
import me.nathanfallet.ktorx.models.annotations.Path
import me.nathanfallet.ktorx.models.annotations.TemplateMapping
import me.nathanfallet.ktorx.models.responses.RedirectResponse

interface IWebController : IUnitController {

    @TemplateMapping("public/home.ftl")
    @Path("GET", "/")
    suspend fun home(): Map<String, Any>

    @TemplateMapping("public/home.ftl")
    @Path("GET", "/discord")
    fun discord(): RedirectResponse

}
