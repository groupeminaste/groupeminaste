package me.nathanfallet.groupeminaste.controllers.web

import me.nathanfallet.groupeminaste.models.application.GetInTouchPayload
import me.nathanfallet.ktorx.controllers.IUnitController
import me.nathanfallet.ktorx.models.annotations.Path
import me.nathanfallet.ktorx.models.annotations.PathParameter
import me.nathanfallet.ktorx.models.annotations.Payload
import me.nathanfallet.ktorx.models.annotations.TemplateMapping
import me.nathanfallet.ktorx.models.responses.RedirectResponse

interface IWebController : IUnitController {

    @TemplateMapping("public/home.ftl")
    @Path("GET", "/")
    suspend fun home(): Map<String, Any>

    @TemplateMapping("public/mentions-legales.ftl")
    @Path("GET", "/mentions-legales")
    suspend fun mentionsLegales()

    @TemplateMapping("public/home.ftl")
    @Path("GET", "/discord")
    fun discord(): RedirectResponse

    @TemplateMapping("public/getintouch.ftl")
    @Path("POST", "/getintouch")
    suspend fun getInTouch(@Payload payload: GetInTouchPayload)

    @TemplateMapping("public/home.ftl")
    @Path("GET", "/infos/{file}")
    suspend fun infos(@PathParameter file: String): RedirectResponse

}
