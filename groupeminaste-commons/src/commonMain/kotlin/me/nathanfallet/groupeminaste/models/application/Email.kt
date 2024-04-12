package me.nathanfallet.groupeminaste.models.application

import me.nathanfallet.usecases.emails.IEmail

data class Email(
    val title: String,
    val body: String,
) : IEmail
