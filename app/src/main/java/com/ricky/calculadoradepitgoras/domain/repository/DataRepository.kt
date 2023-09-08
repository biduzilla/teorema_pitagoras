package com.ricky.calculadoradepitgoras.domain.repository

import com.ricky.calculadoradepitgoras.domain.models.Calculo
import kotlinx.coroutines.flow.Flow

interface DataRepository {

    fun getAllCalculo(): Flow<List<Calculo>>
    suspend fun insertCalculo(calculo: Calculo)
    suspend fun deleteCalculo(calculo: Calculo)
}