package com.developbharat.facegate.domain.uses.settings

import com.developbharat.facegate.domain.models.settings.AdvancedOptions
import com.developbharat.facegate.domain.store.ISharedStore
import javax.inject.Inject

class UseAdvancedOptionsUseCase @Inject constructor(private val sharedStore: ISharedStore) {
    operator fun invoke(): AdvancedOptions {
        val isStored = sharedStore.isValueAvailable(ISharedStore.ADVANCED_OPTIONS)
        if (!isStored) {
            val options = AdvancedOptions()
            sharedStore.setValue(ISharedStore.ADVANCED_OPTIONS, options)
            return options
        }
        return sharedStore.useValue(ISharedStore.ADVANCED_OPTIONS, AdvancedOptions::class.java)
    }
}