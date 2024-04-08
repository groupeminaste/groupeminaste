package me.nathanfallet.groupeminaste.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import me.nathanfallet.groupeminaste.models.application.GroupeMinasteJson

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(GroupeMinasteJson.json)
    }
}
