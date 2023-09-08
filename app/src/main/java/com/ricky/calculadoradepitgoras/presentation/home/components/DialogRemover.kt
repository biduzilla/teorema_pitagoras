package com.ricky.calculadoradepitgoras.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ricky.calculadoradepitgoras.R

@Composable
fun DialogRemover(
    modifier: Modifier = Modifier,
    onDimiss: () -> Unit,
    onRemover: () -> Unit
) {

    AlertDialog(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        text = {
            Text(
                text = stringResource(id = R.string.apagar_item),
                style = MaterialTheme.typography.bodyLarge
            )
        },
        onDismissRequest = { onDimiss() },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { onRemover() }) {
                    Text(text = stringResource(id = R.string.apagar))
                }
                Button(onClick = { onDimiss() }) {
                    Text(text = stringResource(id = R.string.cancelar))
                }
            }
        },
    )
}
