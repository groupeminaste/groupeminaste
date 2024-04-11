package me.nathanfallet.groupeminaste.controllers.dashboard

import me.nathanfallet.ktorx.controllers.IUnitController
import me.nathanfallet.ktorx.models.annotations.AdminTemplateMapping
import me.nathanfallet.ktorx.models.annotations.Path

interface IDashboardController : IUnitController {

    @AdminTemplateMapping("admin/dashboard.ftl")
    @Path("GET", "/")
    suspend fun dashboard()

}
