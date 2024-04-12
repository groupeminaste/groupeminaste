package me.nathanfallet.groupeminaste.usecases.application

import me.nathanfallet.groupeminaste.models.application.DiscordWebhook
import me.nathanfallet.usecases.base.IPairSuspendUseCase

interface ISendDiscordWebhookUseCase : IPairSuspendUseCase<DiscordWebhook, String, Unit>
