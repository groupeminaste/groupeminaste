package me.nathanfallet.groupeminaste.usecases.files

import me.nathanfallet.cloudflare.models.r2.Object
import me.nathanfallet.cloudflare.r2.IR2Client

class ListFilesUseCase(
    private val r2Client: IR2Client,
    private val bucket: String,
) : IListFilesUseCase {

    override suspend fun invoke(): List<Object> = r2Client.listObjectsV2(bucket).contents

}
