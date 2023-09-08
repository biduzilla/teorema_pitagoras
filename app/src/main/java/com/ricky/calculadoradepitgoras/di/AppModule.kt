package com.ricky.calculadoradepitgoras.di

import android.content.Context
import androidx.room.Room
import com.ricky.calculadoradepitgoras.data.AppDatabase
import com.ricky.calculadoradepitgoras.data.dao.DataDao
import com.ricky.calculadoradepitgoras.data.repository.DataRepositoryImpl
import com.ricky.calculadoradepitgoras.datastore.DataStoreUtil
import com.ricky.calculadoradepitgoras.domain.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun providePetDao(database: AppDatabase): DataDao = database.calculoDao()


    @Singleton
    @Provides
    fun providePetRepository(dao: DataDao): DataRepository = DataRepositoryImpl(dao)


    @Singleton
    @Provides
    fun provideDataStoreUtil(@ApplicationContext context: Context): DataStoreUtil {
        return DataStoreUtil(context)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db"
        ).fallbackToDestructiveMigration()
            .build()
}


