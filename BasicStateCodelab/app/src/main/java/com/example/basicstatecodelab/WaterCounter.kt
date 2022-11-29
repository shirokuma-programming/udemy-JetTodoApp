package com.example.basicstatecodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Button //step4
import androidx.compose.foundation.layout.Column //step4
import androidx.compose.runtime.MutableState //step5
import androidx.compose.runtime.mutableStateOf //step5
import androidx.compose.runtime.remember //step5
import androidx.compose.runtime.getValue //step5
import androidx.compose.runtime.setValue //step5
import androidx.compose.foundation.layout.Row //step7
import com.example.basicstatecodelab.ui.theme.WellnessTaskItem //step7
import androidx.compose.runtime.saveable.rememberSaveable //step8

//@Composable
//fun WaterCounter(modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        var count by rememberSaveable { mutableStateOf(0) }
//
//        if (count > 0) {
//            var showTask by remember { mutableStateOf(true) }
//            if (showTask) {
//                WellnessTaskItem(
//                    onClose = { showTask = false },
//                    taskName = "タスクする？"
//                )
//            }
//            Text("$count glasses!!!")
//        }
//        Row(Modifier.padding(top = 8.dp)) {
//            Button(onClick = { count++ }, enabled = count < 10) {
//                Text("Add one")
//            }
//            Button(onClick = { count = 0 }, Modifier.padding(start = 8.dp)) {
//                Text("Clear water count")
//            }
//        }
//    }
//}
@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("$count glasses!!!")
        }
        Button(onClick = onIncrement, Modifier.padding(start = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefullCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}