package com.developbharat.facegate.domain.uses.settings

import com.developbharat.facegate.domain.models.settings.FaceMatchOptions
import com.developbharat.facegate.domain.store.ISharedStore
import javax.inject.Inject

class UseFaceMatchOptionsUseCase @Inject constructor(private val sharedStore: ISharedStore) {
    operator fun invoke(): FaceMatchOptions {
        val isStored = sharedStore.isValueAvailable(ISharedStore.FACE_MATCH_OPTIONS)
        if (!isStored) {
            val options = FaceMatchOptions()
            sharedStore.setValue(ISharedStore.FACE_MATCH_OPTIONS, options)
            return options
        }
        return sharedStore.useValue(ISharedStore.FACE_MATCH_OPTIONS, FaceMatchOptions::class.java)
    }
}