package me.nathanfallet.groupeminaste.services.discord

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import me.nathanfallet.groupeminaste.models.application.DiscordWebhook
import me.nathanfallet.groupeminaste.models.application.GroupeMinasteJson

class DiscordService(
    private val getInTouchWebhook: String,
) : IDiscordService {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(GroupeMinasteJson.json)
        }
    }

    override suspend fun sendWebhookMessage(webhook: DiscordWebhook, message: String) {
        val url = when (webhook) {
            DiscordWebhook.GET_IN_TOUCH -> getInTouchWebhook
        }
        client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(mapOf("content" to message))
        }
    }

}
