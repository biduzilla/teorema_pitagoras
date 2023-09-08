package com.ricky.calculadoradepitgoras.presentation.home

import com.ricky.calculadoradepitgoras.domain.models.Calculo

data class HomeState(
    val a: String = "",
    val b: String = "",
    val itens: List<Calculo> = emptyList(),
    val onErrorA: Boolean = false,
    val onErrorB: Boolean = false,
    val isShowDialog: Boolean = false
)
