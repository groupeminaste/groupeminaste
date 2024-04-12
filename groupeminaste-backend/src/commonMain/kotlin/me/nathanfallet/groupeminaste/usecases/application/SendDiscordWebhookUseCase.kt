package me.nathanfallet.groupeminaste.usecases.application

import me.nathanfallet.groupeminaste.models.application.DiscordWebhook
import me.nathanfallet.groupeminaste.services.discord.IDiscordService

class SendDiscordWebhookUseCase(
    private val discordService: IDiscordService,
) : ISendDiscordWebhookUseCase {

    override suspend fun invoke(input1: DiscordWebhook, input2: String) =
        discordService.sendWebhookMessage(input1, input2)

}
