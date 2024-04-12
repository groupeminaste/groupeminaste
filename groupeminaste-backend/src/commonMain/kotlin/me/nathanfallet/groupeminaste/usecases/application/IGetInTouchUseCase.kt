package me.nathanfallet.groupeminaste.usecases.application

import me.nathanfallet.groupeminaste.models.application.GetInTouchPayload
import me.nathanfallet.usecases.base.ISuspendUseCase

interface IGetInTouchUseCase : ISuspendUseCase<GetInTouchPayload, Unit>
