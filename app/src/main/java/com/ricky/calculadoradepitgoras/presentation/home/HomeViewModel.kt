package com.ricky.calculadoradepitgoras.presentation.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricky.calculadoradepitgoras.domain.models.Calculo
import com.ricky.calculadoradepitgoras.domain.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: DataRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllCalculo().collect { itens ->
                _state.update {
                    it.copy(
                        itens = itens
                    )
                }
            }
        }
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnChangeA -> {
                _state.update {
                    it.copy(
                        a = event.a,
                        onErrorA = false
                    )
                }
            }

            is HomeEvent.OnChangeB -> {
                _state.update {
                    it.copy(
                        b = event.b,
                        onErrorB = false
                    )
                }
            }

            HomeEvent.Salvar -> {
                if (_state.value.a.trim().isBlank()) {
                    _state.update {
                        it.copy(
                            onErrorA = true
                        )
                    }
                    return
                }
                if (_state.value.b.trim().isBlank()) {
                    _state.update {
                        it.copy(
                            onErrorB = true
                        )
                    }
                    return
                }

                val xA = BigDecimal(_state.value.a)
                val xB = BigDecimal(_state.value.b)
                val xC = xB.pow(2) + xA.pow(2)

                val calculo = Calculo(
                    a = xA,
                    b = xB,
                    c = xC
                )
                viewModelScope.launch {
                    repository.insertCalculo(calculo)
                }

                _state.update {
                    it.copy(
                        a = "",
                        b = ""
                    )
                }
            }

            is HomeEvent.OnDeleteItem -> {
                viewModelScope.launch {
                    repository.deleteCalculo(event.item)
                }
                _state.update {
                    it.copy(
                        isShowDialog = false
                    )
                }
            }

            HomeEvent.ShowDialog -> {
                _state.update {
                    it.copy(
                        isShowDialog = !_state.value.isShowDialog
                    )
                }
            }
        }
    }
}