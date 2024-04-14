package me.nathanfallet.groupeminaste.controllers.files

import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import kotlinx.datetime.Clock
import me.nathanfallet.cloudflare.models.r2.Object
import me.nathanfallet.groupeminaste.usecases.files.IListFilesUseCase
import me.nathanfallet.groupeminaste.usecases.files.IUploadFileUseCase
import me.nathanfallet.ktorx.models.responses.RedirectResponse

class FilesController(
    private val listFilesUseCase: IListFilesUseCase,
    private val uploadFileUseCase: IUploadFileUseCase,
) : IFilesController {

    override suspend fun list(): List<Object> =
        emptyList() //listFilesUseCase() // To get fixed in cloudflare-api-client

    override suspend fun upload(call: ApplicationCall): RedirectResponse {
        val multipart = call.receiveMultipart()
        multipart.forEachPart { part ->
            if (part is PartData.FileItem) {
                uploadFileUseCase(
                    part.originalFileName ?: "file-${Clock.System.now()}",
                    part.streamProvider(),
                    part.contentType ?: ContentType.Application.OctetStream
                )
            }
            part.dispose()
        }
        return RedirectResponse("files")
    }

}
