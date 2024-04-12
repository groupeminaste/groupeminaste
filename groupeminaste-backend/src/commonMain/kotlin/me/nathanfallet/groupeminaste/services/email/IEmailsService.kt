package me.nathanfallet.groupeminaste.services.email

import me.nathanfallet.usecases.emails.IEmail

interface IEmailsService {

    fun sendEmail(email: IEmail, destination: List<String>)

}
