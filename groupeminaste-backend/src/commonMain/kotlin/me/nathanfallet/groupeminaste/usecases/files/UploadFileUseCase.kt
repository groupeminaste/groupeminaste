package me.nathanfallet.groupeminaste.usecases.files

import io.ktor.http.*
import me.nathanfallet.cloudflare.client.ICloudflareClient
import me.nathanfallet.cloudflare.models.r2.InputStream
import me.nathanfallet.cloudflare.r2.IR2Client

class UploadFileUseCase(
    private val r2Client: IR2Client,
    private val cloudflareClient: ICloudflareClient,
    private val bucket: String,
) : IUploadFileUseCase {

    override suspend fun invoke(input1: String, input2: InputStream, input3: ContentType) {
        r2Client.putObject(bucket, input1, input2, input3)
        cloudflareClient.zones.purgeCache(
            "72356ace5c6fddc79486e6aedab34eb7",
            listOf("https://cdn.groupe-minaste.org/${input1.removePrefix("/")}")
        )
    }

}
