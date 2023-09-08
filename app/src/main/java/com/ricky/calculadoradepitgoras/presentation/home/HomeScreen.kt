package com.ricky.calculadoradepitgoras.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ricky.calculadoradepitgoras.R
import com.ricky.calculadoradepitgoras.presentation.home.components.DialogRemover
import com.ricky.calculadoradepitgoras.presentation.home.components.TextFieldCompose

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {

    val focusManager = LocalFocusManager.current

    LazyColumn(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCompose(
                value = state.a,
                isError = state.onErrorA,
                label = R.string.valor_a,
                onChange = { onEvent(HomeEvent.OnChangeA(it)) },
                keyboardType = KeyboardType.Decimal
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCompose(
                value = state.b,
                isError = state.onErrorB,
                label = R.string.valor_b,
                onChange = { onEvent(HomeEvent.OnChangeB(it)) },
                keyboardType = KeyboardType.Decimal
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                onEvent(HomeEvent.Salvar)
                focusManager.clearFocus()
            }) {
                Text(
                    text = stringResource(id = R.string.calcular),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(state.itens) { item ->
            Spacer(modifier = Modifier.height(16.dp))

            if (state.isShowDialog) {
                DialogRemover(
                    onDimiss = { onEvent(HomeEvent.ShowDialog) },
                    onRemover = { onEvent(HomeEvent.OnDeleteItem(item)) })
            }
            Card(
                elevation = CardDefaults.cardElevation(10.dp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onEvent(HomeEvent.ShowDialog) }
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Valor de A: ${item.a}")
                    Text(text = "Valor de B: ${item.b}")
                    Text(text = "Valor de C: ${item.c}")
                }
            }
        }
    }
}