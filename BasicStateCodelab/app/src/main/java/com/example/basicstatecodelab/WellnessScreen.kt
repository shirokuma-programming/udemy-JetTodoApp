package com.example.basicstatecodelab

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
//    WaterCounter(modifier)　・・step9で削除↓を呼び出すように変更
    StatefullCounter(modifier) //step9で追加呼び出し
}