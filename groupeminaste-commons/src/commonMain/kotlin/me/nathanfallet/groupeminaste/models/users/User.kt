package me.nathanfallet.groupeminaste.models.users

import kotlinx.serialization.Serializable
import me.nathanfallet.usecases.models.IModel
import me.nathanfallet.usecases.models.annotations.Schema
import me.nathanfallet.usecases.users.IUser

@Serializable
data class User(
    @Schema("Id of the User", "123abc")
    override val id: String,
    @Schema("Name of the User", "Nathan Fallet")
    val name: String,
    @Schema("Email of the User", "contact@nathanfallet.me")
    val email: String? = null,
    val password: String? = null,
    @Schema("Biography of the User", "Hi, I'm a developer")
    val biography: String? = null,
    @Schema("Avatar of the User", "https://...")
    val avatar: String? = null,
    @Schema("Website of the User", "https://...")
    val website: String? = null,
) : IModel<String, Unit, Unit>, IUser
