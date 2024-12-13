package com.developbharat.facegate.domain.uses.settings

import com.developbharat.facegate.domain.models.settings.GlobalOptions
import com.developbharat.facegate.domain.store.ISharedStore
import javax.inject.Inject

class UseGlobalOptionsUseCase @Inject constructor(private val sharedStore: ISharedStore) {
    operator fun invoke(): GlobalOptions {
        val isStored = sharedStore.isValueAvailable(ISharedStore.GLOBAL_OPTIONS)
        if (!isStored) {
            val options = GlobalOptions()
            sharedStore.setValue(ISharedStore.GLOBAL_OPTIONS, options)
            return options
        }
        return sharedStore.useValue(ISharedStore.GLOBAL_OPTIONS, GlobalOptions::class.java)
    }
}