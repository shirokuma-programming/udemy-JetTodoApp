package com.example.basicstatecodelab

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }