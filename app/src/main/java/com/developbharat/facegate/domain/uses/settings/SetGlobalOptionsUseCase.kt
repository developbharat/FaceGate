package com.developbharat.facegate.domain.uses.settings

import com.developbharat.facegate.domain.models.settings.GlobalOptions
import com.developbharat.facegate.domain.store.ISharedStore
import javax.inject.Inject

class SetGlobalOptionsUseCase @Inject constructor(private val sharedStore: ISharedStore) {
    operator fun invoke(options: GlobalOptions): GlobalOptions {
        sharedStore.setValue(ISharedStore.GLOBAL_OPTIONS, options)
        return options
    }
}