package com.developbharat.facegate.domain.uses.settings

import com.developbharat.facegate.domain.models.settings.AttendanceSheetOptions
import com.developbharat.facegate.domain.store.ISharedStore
import javax.inject.Inject

class UseAttendanceSheetOptionsUseCase @Inject constructor(private val sharedStore: ISharedStore) {
    operator fun invoke(): AttendanceSheetOptions {
        val isStored = sharedStore.isValueAvailable(ISharedStore.ATTENDANCE_SHEET_OPTIONS)
        if (!isStored) {
            val options = AttendanceSheetOptions()
            sharedStore.setValue(ISharedStore.ATTENDANCE_SHEET_OPTIONS, options)
            return options
        }
        return sharedStore.useValue(ISharedStore.ATTENDANCE_SHEET_OPTIONS, AttendanceSheetOptions::class.java)
    }
}