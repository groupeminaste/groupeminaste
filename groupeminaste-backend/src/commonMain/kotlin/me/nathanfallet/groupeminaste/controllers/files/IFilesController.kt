package me.nathanfallet.groupeminaste.controllers.files

import io.ktor.server.application.*
import me.nathanfallet.cloudflare.models.r2.Object
import me.nathanfallet.ktorx.controllers.IUnitController
import me.nathanfallet.ktorx.models.annotations.AdminTemplateMapping
import me.nathanfallet.ktorx.models.annotations.ListModelPath
import me.nathanfallet.ktorx.models.annotations.Path
import me.nathanfallet.ktorx.models.responses.RedirectResponse

interface IFilesController : IUnitController {

    @AdminTemplateMapping("admin/files/list.ftl")
    @ListModelPath
    suspend fun list(): List<Object>

    @AdminTemplateMapping("admin/files/list.ftl")
    @Path("POST", "/")
    suspend fun upload(call: ApplicationCall): RedirectResponse

}
