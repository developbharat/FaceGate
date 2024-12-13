package com.developbharat.facegate.domain.uses.settings

import com.developbharat.facegate.domain.models.settings.AdvancedOptions
import com.developbharat.facegate.domain.store.ISharedStore
import javax.inject.Inject

class SetAdvancedOptionsUseCase @Inject constructor(private val sharedStore: ISharedStore) {
    operator fun invoke(options: AdvancedOptions): AdvancedOptions {
        sharedStore.setValue(ISharedStore.ADVANCED_OPTIONS, options)
        return options
    }
}