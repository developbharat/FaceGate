package com.developbharat.facegate.domain.uses.settings

import com.developbharat.facegate.domain.models.settings.FaceMatchOptions
import com.developbharat.facegate.domain.store.ISharedStore
import javax.inject.Inject

class SetFaceMatchOptionsUseCase @Inject constructor(private val sharedStore: ISharedStore) {
    operator fun invoke(options: FaceMatchOptions): FaceMatchOptions {
        sharedStore.setValue(ISharedStore.FACE_MATCH_OPTIONS, options)
        return options
    }
}