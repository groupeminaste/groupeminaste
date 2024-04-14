package me.nathanfallet.groupeminaste.usecases.files

import me.nathanfallet.cloudflare.models.r2.Object
import me.nathanfallet.usecases.base.IUnitSuspendUseCase

interface IListFilesUseCase : IUnitSuspendUseCase<List<Object>>
