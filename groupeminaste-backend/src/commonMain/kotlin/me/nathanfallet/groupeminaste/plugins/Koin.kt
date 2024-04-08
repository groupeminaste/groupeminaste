package me.nathanfallet.groupeminaste.plugins

import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.controllers.auth.AuthController
import me.nathanfallet.groupeminaste.controllers.auth.AuthRouter
import me.nathanfallet.groupeminaste.controllers.auth.IAuthController
import me.nathanfallet.groupeminaste.controllers.projects.IProjectsController
import me.nathanfallet.groupeminaste.controllers.projects.ProjectsController
import me.nathanfallet.groupeminaste.controllers.projects.ProjectsRouter
import me.nathanfallet.groupeminaste.controllers.web.IWebController
import me.nathanfallet.groupeminaste.controllers.web.WebController
import me.nathanfallet.groupeminaste.controllers.web.WebRouter
import me.nathanfallet.groupeminaste.database.Database
import me.nathanfallet.groupeminaste.database.projects.ProjectsDatabaseRepository
import me.nathanfallet.groupeminaste.database.users.UsersDatabaseRepository
import me.nathanfallet.groupeminaste.models.projects.Project
import me.nathanfallet.groupeminaste.models.users.User
import me.nathanfallet.groupeminaste.repositories.projects.IProjectsRepository
import me.nathanfallet.groupeminaste.repositories.users.IUsersRepository
import me.nathanfallet.groupeminaste.services.jwt.IJWTService
import me.nathanfallet.groupeminaste.services.jwt.JWTService
import me.nathanfallet.groupeminaste.usecases.auth.*
import me.nathanfallet.groupeminaste.usecases.users.GetUserForCallUseCase
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
import me.nathanfallet.usecases.models.get.GetModelFromRepositorySuspendUseCase
import me.nathanfallet.usecases.models.get.IGetModelSuspendUseCase
import me.nathanfallet.usecases.models.list.IListModelSuspendUseCase
import me.nathanfallet.usecases.models.list.ListModelFromRepositorySuspendUseCase
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
        }
        val controllerModule = module {
            // Static web pages
            single<IWebController> {
                WebController(
                    get(named<User>()),
                    get(named<Project>())
                )
            }

            // Auth
            single<IAuthController> { AuthController(get(), get(), get()) }

            // Projects
            single<IProjectsController> {
                ProjectsController(
                    get(named<Project>())
                )
            }
        }
        val routerModule = module {
            single { WebRouter(get(), get()) }
            single { AuthRouter(get(), get()) }
            single { ProjectsRouter(get(), get()) }
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
