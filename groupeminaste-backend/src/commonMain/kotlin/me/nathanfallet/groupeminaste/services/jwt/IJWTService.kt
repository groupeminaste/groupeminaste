package me.nathanfallet.groupeminaste.services.jwt

interface IJWTService {

    fun generateJWT(userId: String, clientId: String, type: String): String

}
