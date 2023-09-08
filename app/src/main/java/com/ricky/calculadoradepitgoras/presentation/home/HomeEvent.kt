package com.ricky.calculadoradepitgoras.presentation.home

import com.ricky.calculadoradepitgoras.domain.models.Calculo

sealed interface HomeEvent {

    data class OnChangeA(val a: String) : HomeEvent
    data class OnChangeB(val b: String) : HomeEvent
    data class OnDeleteItem(val item: Calculo) : HomeEvent
    object Salvar : HomeEvent
    object ShowDialog : HomeEvent
}