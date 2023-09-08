package com.ricky.calculadoradepitgoras.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ricky.calculadoradepitgoras.domain.models.Calculo
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDao
{
    @Query("SELECT * FROM Calculo")
    fun getAllCalculo(): Flow<List<Calculo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCalculo(calculo: Calculo)

    @Delete
    suspend fun deleteCalculo(calculo: Calculo)
}