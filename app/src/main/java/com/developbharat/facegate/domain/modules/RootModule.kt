package com.developbharat.facegate.domain.modules

import android.content.Context
import com.developbharat.facegate.domain.data.ISQLiteDatabase
import com.developbharat.facegate.domain.data.SQLiteDatabase
import com.developbharat.facegate.domain.ml.FaceNetModel
import com.developbharat.facegate.domain.ml.IFaceNetModel
import com.developbharat.facegate.domain.models.settings.AttendanceSheetOptions
import com.developbharat.facegate.domain.models.settings.GlobalOptions
import com.developbharat.facegate.domain.repos.batch.BatchRepository
import com.developbharat.facegate.domain.repos.batch.IBatchRepository
import com.developbharat.facegate.domain.repos.device.DeviceState
import com.developbharat.facegate.domain.repos.device.IDeviceState
import com.developbharat.facegate.domain.repos.facematch.FaceMatchRepository
import com.developbharat.facegate.domain.repos.facematch.IFaceMatchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RootModule {

    @Provides
    @Singleton
    fun providesBatchRepository(): IBatchRepository {
        return BatchRepository()
    }

    @Provides
    @Singleton
    fun providesDeviceState(@ApplicationContext appContext: Context): IDeviceState {
        return DeviceState(appContext)
    }

    @Provides
    @Singleton
    fun providesFaceMatchRepository(
        faceNetModel: IFaceNetModel,
        database: ISQLiteDatabase
    ): IFaceMatchRepository {
        // TODO: dynamically load attendance sheet options
        return FaceMatchRepository(
            facenetModel = faceNetModel,
            database = database,
            attendanceSheetOptions = AttendanceSheetOptions()
        )
    }

    @Provides
    @Singleton
    fun providesFaceNetModel(@ApplicationContext appContext: Context): IFaceNetModel {
        // TODO: dynamically load global options
        return FaceNetModel(appContext = appContext, globalOptions = GlobalOptions())
    }

    @Provides
    @Singleton
    fun providesSQLiteDatabase(@ApplicationContext appContext: Context): ISQLiteDatabase {
        return SQLiteDatabase(appContext)
    }
}