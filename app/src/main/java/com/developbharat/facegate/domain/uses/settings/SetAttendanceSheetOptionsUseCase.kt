package com.developbharat.facegate.domain.uses.settings

import com.developbharat.facegate.domain.models.settings.AttendanceSheetOptions
import com.developbharat.facegate.domain.store.ISharedStore
import javax.inject.Inject

class SetAttendanceSheetOptionsUseCase @Inject constructor(private val sharedStore: ISharedStore) {
    operator fun invoke(options: AttendanceSheetOptions): AttendanceSheetOptions {
        sharedStore.setValue(ISharedStore.ATTENDANCE_SHEET_OPTIONS, options)
        return options
    }
}