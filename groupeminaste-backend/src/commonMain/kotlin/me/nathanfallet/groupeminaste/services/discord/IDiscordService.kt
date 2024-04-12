package me.nathanfallet.groupeminaste.services.discord

import me.nathanfallet.groupeminaste.models.application.DiscordWebhook

interface IDiscordService {

    suspend fun sendWebhookMessage(webhook: DiscordWebhook, message: String)

}
