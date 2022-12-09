package com.example.udemy_jetbmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

/*
* BMI計算アプリ画面のViewModel
* **/
class MainActivityViewModel : ViewModel() {
    // 身長
    var height by mutableStateOf("")
    // 体重
    var weight by mutableStateOf("")
    // BMI
    var bmi by mutableStateOf(0f)

    // BMI = (体重kg) / (身長m) ** 2
    fun calculateBMI() {
        val heightNumber = height.toFloatOrNull()?.div(100) ?: 0f
        val weightNumber = weight.toFloatOrNull() ?: 0f

        bmi = if (weightNumber > 0f && heightNumber > 0f) {
            (weightNumber / heightNumber.pow(2) * 10).roundToInt() /10f
        } else 0f
    }
}