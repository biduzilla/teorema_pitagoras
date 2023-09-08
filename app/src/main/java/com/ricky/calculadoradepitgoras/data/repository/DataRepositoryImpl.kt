package com.ricky.calculadoradepitgoras.data.repository

import com.ricky.calculadoradepitgoras.data.dao.DataDao
import com.ricky.calculadoradepitgoras.domain.models.Calculo
import com.ricky.calculadoradepitgoras.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val dao: DataDao): DataRepository {
    override fun getAllCalculo(): Flow<List<Calculo>> {
        return dao.getAllCalculo()
    }

    override suspend fun insertCalculo(calculo: Calculo) {
        dao.insertCalculo(calculo)
    }

    override suspend fun deleteCalculo(calculo: Calculo) {
        dao.deleteCalculo(calculo)
    }
}