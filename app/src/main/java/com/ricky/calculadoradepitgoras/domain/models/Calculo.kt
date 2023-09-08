package com.ricky.calculadoradepitgoras.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.UUID

@Entity
data class Calculo(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val a: BigDecimal = BigDecimal(0.0),
    val b: BigDecimal = BigDecimal(0.0),
    val c: BigDecimal = BigDecimal(0.0),
)
