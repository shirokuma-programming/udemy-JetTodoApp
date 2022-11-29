package com.example.basicstatecodelab.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding

// step10
import androidx.compose.material.Checkbox
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean, // step10
    onClose: () -> Unit,
    onCheckedChange: (Boolean) -> Unit, // step10
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

// step10
@Composable
fun WellnessTaskItem(taskName: String, modifier: Modifier = Modifier) {
    var checkedState by remember { mutableStateOf(false) }

    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onClose = { /*TODO*/ },
        onCheckedChange = { newValue -> checkedState = newValue },
        modifier = modifier
    )
}