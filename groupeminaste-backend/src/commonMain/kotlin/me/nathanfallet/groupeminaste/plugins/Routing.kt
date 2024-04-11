package me.nathanfallet.groupeminaste.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.servers.Server
import me.nathanfallet.groupeminaste.controllers.auth.AuthRouter
import me.nathanfallet.groupeminaste.controllers.dashboard.DashboardRouter
import me.nathanfallet.groupeminaste.controllers.projects.ProjectsRouter
import me.nathanfallet.groupeminaste.controllers.web.WebRouter
import me.nathanfallet.ktorx.extensions.info
import me.nathanfallet.ktorx.routers.openapi.OpenAPIRouter
import org.koin.ktor.ext.get

fun Application.configureRouting() {
    install(IgnoreTrailingSlash)
    routing {
        val openAPI = OpenAPI().info {
            this.title = "Groupe MINASTE API"
            this.description = "Groupe MINASTE API"
            this.version = "1.0.0"
        }
        openAPI.servers(
            listOf(
                Server().description("Production server").url("https://groupe-minaste.org"),
            )
        )

        authenticate("api-v1-jwt", optional = true) {
            listOf(
                get<WebRouter>(),
                get<AuthRouter>(),
                get<DashboardRouter>(),
                get<ProjectsRouter>(),
                OpenAPIRouter(), // OpenAPI should be last
            ).forEach {
                it.createRoutes(this, openAPI)
            }
        }

        staticResources("", "static")
    }
}
