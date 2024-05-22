package me.nathanfallet.groupeminaste.client

import me.nathanfallet.groupeminaste.models.application.GroupeMinasteJson
import me.nathanfallet.ktorx.models.api.AbstractAPIClient
import me.nathanfallet.ktorx.usecases.api.IGetTokenUseCase

class GroupeMinasteClient(
    getTokenUseCase: IGetTokenUseCase,
) : AbstractAPIClient(
    "https://groupe-minaste.org",
    getTokenUseCase,
    json = GroupeMinasteJson.json
), IGroupeMinasteClient {

}
