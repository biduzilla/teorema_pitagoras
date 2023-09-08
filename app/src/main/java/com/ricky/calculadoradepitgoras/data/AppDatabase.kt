package com.ricky.calculadoradepitgoras.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ricky.calculadoradepitgoras.data.converters.Converters
import com.ricky.calculadoradepitgoras.data.dao.DataDao
import com.ricky.calculadoradepitgoras.domain.models.Calculo

@Database(
    entities = [
        Calculo::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun calculoDao(): DataDao
}