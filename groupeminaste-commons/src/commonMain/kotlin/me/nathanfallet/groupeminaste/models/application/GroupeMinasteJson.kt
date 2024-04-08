package me.nathanfallet.groupeminaste.models.application

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object GroupeMinasteJson {

    @OptIn(ExperimentalSerializationApi::class)
    val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

}
