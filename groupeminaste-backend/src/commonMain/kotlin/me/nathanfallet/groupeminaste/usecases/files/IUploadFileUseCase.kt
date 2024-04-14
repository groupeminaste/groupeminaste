package me.nathanfallet.groupeminaste.usecases.files

import io.ktor.http.*
import me.nathanfallet.cloudflare.models.r2.InputStream
import me.nathanfallet.usecases.base.ITripleSuspendUseCase

interface IUploadFileUseCase : ITripleSuspendUseCase<String, InputStream, ContentType, Unit>
