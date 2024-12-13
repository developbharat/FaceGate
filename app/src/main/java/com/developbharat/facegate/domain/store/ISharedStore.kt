package com.developbharat.facegate.domain.store

interface ISharedStore {
    fun <T> setValue(name: String, value: T)
    fun <T> useValue(name: String, clazz: Class<T>): T
    fun deleteValue(name: String)
    fun isValueAvailable(name: String): Boolean

    companion object {
        const val GLOBAL_OPTIONS = "GLOBAL_OPTIONS"
        const val FACE_MATCH_OPTIONS = "FACE_MATCH_OPTIONS"
        const val ATTENDANCE_SHEET_OPTIONS = "ATTENDANCE_SHEET_OPTIONS"
        const val ADVANCED_OPTIONS = "ADVANCED_OPTIONS"
    }
}