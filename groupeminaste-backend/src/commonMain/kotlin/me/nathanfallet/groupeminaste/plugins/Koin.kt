package me.nathanfallet.groupeminaste.plugins

import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.controllers.auth.AuthController
import me.nathanfallet.groupeminaste.controllers.auth.AuthRouter
import me.nathanfallet.groupeminaste.controllers.auth.IAuthController
import me.nathanfallet.groupeminaste.controllers.dashboard.DashboardController
import me.nathanfallet.groupeminaste.controllers.dashboard.DashboardRouter
import me.nathanfallet.groupeminaste.controllers.dashboard.IDashboardController
import me.nathanfallet.groupeminaste.controllers.projects.*
import me.nathanfallet.groupeminaste.controllers.web.IWebController
import me.nathanfallet.groupeminaste.controllers.web.WebController
import me.nathanfallet.groupeminaste.controllers.web.WebRouter
import me.nathanfallet.groupeminaste.database.Database
import me.nathanfallet.groupeminaste.database.projects.ProjectLinksDatabaseRepository
import me.nathanfallet.groupeminaste.database.projects.ProjectsDatabaseRepository
import me.nathanfallet.groupeminaste.database.users.UsersDatabaseRepository
import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.projects.ProjectLink
import me.nathanfallet.groupeminaste.models.projects.ProjectLinkPayload
import me.nathanfallet.groupeminaste.models.projects.ProjectPayload
import me.nathanfallet.groupeminaste.models.users.User
import me.nathanfallet.groupeminaste.repositories.projects.IProjectLinksRepository
import me.nathanfallet.groupeminaste.repositories.projects.IProjectsRepository
import me.nathanfallet.groupeminaste.repositories.users.IUsersRepository
import me.nathanfallet.groupeminaste.services.jwt.IJWTService
import me.nathanfallet.groupeminaste.services.jwt.JWTService
import me.nathanfallet.groupeminaste.usecases.auth.*
import me.nathanfallet.groupeminaste.usecases.users.GetUserForCallUseCase
import me.nathanfallet.groupeminaste.usecases.web.GetAdminMenuForCallUseCase
import me.nathanfallet.groupeminaste.usecases.web.IGetAdminMenuForCallUseCase
import me.nathanfallet.i18n.usecases.localization.TranslateUseCase
import me.nathanfallet.ktorx.database.sessions.SessionsDatabaseRepository
import me.nathanfallet.ktorx.repositories.sessions.ISessionsRepository
import me.nathanfallet.ktorx.usecases.localization.GetLocaleForCallUseCase
import me.nathanfallet.ktorx.usecases.localization.IGetLocaleForCallUseCase
import me.nathanfallet.ktorx.usecases.users.IGetUserForCallUseCase
import me.nathanfallet.ktorx.usecases.users.IRequireUserForCallUseCase
import me.nathanfallet.ktorx.usecases.users.RequireUserForCallUseCase
import me.nathanfallet.surexposed.database.IDatabase
import me.nathanfallet.usecases.localization.ITranslateUseCase
import me.nathanfallet.usecases.models.create.CreateChildModelFromRepositorySuspendUseCase
import me.nathanfallet.usecases.models.create.CreateModelFromRepositorySuspendUseCase
import me.nathanfallet.usecases.models.create.ICreateChildModelSuspendUseCase
import me.nathanfallet.usecases.models.create.ICreateModelSuspendUseCase
import me.nathanfallet.usecases.models.delete.DeleteChildModelFromRepositorySuspendUseCase
import me.nathanfallet.usecases.models.delete.DeleteModelFromRepositorySuspendUseCase
import me.nathanfallet.usecases.models.delete.IDeleteChildModelSuspendUseCase
import me.nathanfallet.usecases.models.delete.IDeleteModelSuspendUseCase
import me.nathanfallet.usecases.models.get.GetChildModelFromRepositorySuspendUseCase
import me.nathanfallet.usecases.models.get.GetModelFromRepositorySuspendUseCase
import me.nathanfallet.usecases.models.get.IGetChildModelSuspendUseCase
import me.nathanfallet.usecases.models.get.IGetModelSuspendUseCase
import me.nathanfallet.usecases.models.list.IListChildModelSuspendUseCase
import me.nathanfallet.usecases.models.list.IListModelSuspendUseCase
import me.nathanfallet.usecases.models.list.ListChildModelFromRepositorySuspendUseCase
import me.nathanfallet.usecases.models.list.ListModelFromRepositorySuspendUseCase
import me.nathanfallet.usecases.models.update.IUpdateChildModelSuspendUseCase
import me.nathanfallet.usecases.models.update.IUpdateModelSuspendUseCase
import me.nathanfallet.usecases.models.update.UpdateChildModelFromRepositorySuspendUseCase
import me.nathanfallet.usecases.models.update.UpdateModelFromRepositorySuspendUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        val databaseModule = module {
            single<IDatabase> {
                Database(
                    environment.config.property("database.protocol").getString(),
                    environment.config.property("database.host").getString(),
                    environment.config.property("database.name").getString(),
                    environment.config.property("database.user").getString(),
                    environment.config.property("database.password").getString()
                )
            }
        }
        val serviceModule = module {
            single<IJWTService> {
                JWTService(
                    environment.config.property("jwt.secret").getString(),
                    environment.config.property("jwt.issuer").getString()
                )
            }
        }
        val repositoryModule = module {
            // Application
            single<ISessionsRepository> { SessionsDatabaseRepository(get()) }

            // Users
            single<IUsersRepository> { UsersDatabaseRepository(get()) }

            // Projects
            single<IProjectsRepository> { ProjectsDatabaseRepository(get()) }
            single<IProjectLinksRepository> { ProjectLinksDatabaseRepository(get()) }
        }
        val useCaseModule = module {
            // Application
            single<ITranslateUseCase> { TranslateUseCase() }
            single<IGetLocaleForCallUseCase> { GetLocaleForCallUseCase() }

            // Auth
            single<IHashPasswordUseCase> { HashPasswordUseCase() }
            single<IVerifyPasswordUseCase> { VerifyPasswordUseCase() }
            single<IGetJWTPrincipalForCallUseCase> { GetJWTPrincipalForCallUseCase() }
            single<IGetSessionForCallUseCase> { GetSessionForCallUseCase() }
            single<ISetSessionForCallUseCase> { SetSessionForCallUseCase() }
            single<IClearSessionForCallUseCase> { ClearSessionForCallUseCase() }
            single<ILoginUseCase> { LoginUseCase(get(), get()) }

            // Web
            single<IGetAdminMenuForCallUseCase> { GetAdminMenuForCallUseCase(get(), get(), get()) }

            // Users
            single<IRequireUserForCallUseCase> { RequireUserForCallUseCase(get()) }
            single<IGetUserForCallUseCase> { GetUserForCallUseCase(get(), get(), get(named<User>())) }
            single<IListModelSuspendUseCase<User>>(named<User>()) {
                ListModelFromRepositorySuspendUseCase(get<IUsersRepository>())
            }
            single<IGetModelSuspendUseCase<User, String>>(named<User>()) {
                GetModelFromRepositorySuspendUseCase(get<IUsersRepository>())
            }

            // Projects
            single<IListModelSuspendUseCase<Project>>(named<Project>()) {
                ListModelFromRepositorySuspendUseCase(get<IProjectsRepository>())
            }
            single<IGetModelSuspendUseCase<Project, String>>(named<Project>()) {
                GetModelFromRepositorySuspendUseCase(get<IProjectsRepository>())
            }
            single<ICreateModelSuspendUseCase<Project, ProjectPayload>>(named<Project>()) {
                CreateModelFromRepositorySuspendUseCase(get<IProjectsRepository>())
            }
            single<IUpdateModelSuspendUseCase<Project, String, ProjectPayload>>(named<Project>()) {
                UpdateModelFromRepositorySuspendUseCase(get<IProjectsRepository>())
            }
            single<IDeleteModelSuspendUseCase<Project, String>>(named<Project>()) {
                DeleteModelFromRepositorySuspendUseCase(get<IProjectsRepository>())
            }
            single<IListChildModelSuspendUseCase<ProjectLink, String>>(named<ProjectLink>()) {
                ListChildModelFromRepositorySuspendUseCase(get<IProjectLinksRepository>())
            }
            single<IGetChildModelSuspendUseCase<ProjectLink, String, String>>(named<ProjectLink>()) {
                GetChildModelFromRepositorySuspendUseCase(get<IProjectLinksRepository>())
            }
            single<ICreateChildModelSuspendUseCase<ProjectLink, ProjectLinkPayload, String>>(named<ProjectLink>()) {
                CreateChildModelFromRepositorySuspendUseCase(get<IProjectLinksRepository>())
            }
            single<IUpdateChildModelSuspendUseCase<ProjectLink, String, ProjectLinkPayload, String>>(named<ProjectLink>()) {
                UpdateChildModelFromRepositorySuspendUseCase(get<IProjectLinksRepository>())
            }
            single<IDeleteChildModelSuspendUseCase<ProjectLink, String, String>>(named<ProjectLink>()) {
                DeleteChildModelFromRepositorySuspendUseCase(get<IProjectLinksRepository>())
            }
        }
        val controllerModule = module {
            // Static web pages
            single<IWebController> {
                WebController(
                    get(named<User>()),
                    get(named<Project>())
                )
            }
            single<IDashboardController> { DashboardController() }

            // Auth
            single<IAuthController> { AuthController(get(), get(), get()) }

            // Projects
            single<IProjectsController> {
                ProjectsController(
                    get(),
                    get(named<Project>()),
                    get(named<Project>()),
                    get(named<Project>()),
                    get(named<Project>()),
                    get(named<Project>()),
                    get(named<ProjectLink>())
                )
            }
            single<IProjectLinksController> {
                ProjectLinksController(
                    get(),
                    get(named<ProjectLink>()),
                    get(named<ProjectLink>()),
                    get(named<ProjectLink>()),
                    get(named<ProjectLink>()),
                    get(named<ProjectLink>())
                )
            }
        }
        val routerModule = module {
            single { WebRouter(get(), get()) }
            single { AuthRouter(get(), get()) }
            single { DashboardRouter(get(), get(), get(), get()) }
            single { ProjectsRouter(get(), get(), get(), get()) }
            single { ProjectLinksRouter(get(), get(), get(), get(), get()) }
        }

        modules(
            databaseModule,
            serviceModule,
            repositoryModule,
            useCaseModule,
            controllerModule,
            routerModule
        )
    }
}
