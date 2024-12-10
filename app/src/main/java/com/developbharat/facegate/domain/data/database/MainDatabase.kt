package com.developbharat.facegate.domain.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.developbharat.facegate.domain.data.database.convertors.LocalDateTimeConvertor
import com.developbharat.facegate.domain.data.database.dao.BatchDao
import com.developbharat.facegate.domain.data.database.dao.PeopleDao
import com.developbharat.facegate.domain.data.database.entities.BatchRecord
import com.developbharat.facegate.domain.data.database.entities.PeopleRecord


@Database(entities = [BatchRecord::class, PeopleRecord::class], version = 1, exportSchema = false)
@TypeConverters(LocalDateTimeConvertor::class)
abstract class MainDatabase : RoomDatabase() {
    abstract fun batchDao(): BatchDao
    abstract fun peopleDao(): PeopleDao

    companion object {
        // TODO: Add sqlcipher encryption for database.
        fun createInstance(appContext: Context): MainDatabase {
            val db = Room.databaseBuilder(appContext, MainDatabase::class.java, "data").build()
            return db
        }
    }
}


