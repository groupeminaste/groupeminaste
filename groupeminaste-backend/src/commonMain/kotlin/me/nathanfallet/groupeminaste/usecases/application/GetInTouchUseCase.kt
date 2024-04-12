package me.nathanfallet.groupeminaste.usecases.application

import me.nathanfallet.groupeminaste.models.application.DiscordWebhook
import me.nathanfallet.groupeminaste.models.application.Email
import me.nathanfallet.groupeminaste.models.application.GetInTouchPayload
import me.nathanfallet.usecases.emails.ISendEmailUseCase

class GetInTouchUseCase(
    private val sendEmailUseCase: ISendEmailUseCase,
    private val sendDiscordWebhookUseCase: ISendDiscordWebhookUseCase,
) : IGetInTouchUseCase {

    override suspend fun invoke(input: GetInTouchPayload) {
        val message = """
            |Nom: ${input.name}
            |Email: ${input.email}
            |
            |Message:
            |${input.message}
        """.trimMargin()

        sendEmailUseCase(
            Email("Have an Project in Mind?", message),
            listOf("contact@groupe-minaste.org")
        )
        sendDiscordWebhookUseCase(
            DiscordWebhook.GET_IN_TOUCH,
            message
        )
    }

}
