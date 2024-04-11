package me.nathanfallet.groupeminaste.usecases.web

import io.ktor.server.application.*
import me.nathanfallet.groupeminaste.models.users.User
import me.nathanfallet.groupeminaste.models.web.WebMenu
import me.nathanfallet.ktorx.usecases.localization.IGetLocaleForCallUseCase
import me.nathanfallet.ktorx.usecases.users.IRequireUserForCallUseCase
import me.nathanfallet.usecases.localization.ITranslateUseCase

class GetAdminMenuForCallUseCase(
    private val requireUserForCallUseCase: IRequireUserForCallUseCase,
    private val getLocaleForCallUseCase: IGetLocaleForCallUseCase,
    private val translateUseCase: ITranslateUseCase,
) : IGetAdminMenuForCallUseCase {

    override suspend fun invoke(input: ApplicationCall): List<WebMenu> {
        requireUserForCallUseCase(input) as User
        val locale = getLocaleForCallUseCase(input)
        return listOf("dashboard", "projects")
            .map {
                WebMenu(
                    it,
                    translateUseCase(locale, "admin_menu_$it"),
                    if (it == "dashboard") "/admin" else "/admin/$it"
                )
            }
    }

}
