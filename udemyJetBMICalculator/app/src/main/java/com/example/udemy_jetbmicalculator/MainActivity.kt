package com.example.udemy_jetbmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.udemy_jetbmicalculator.ui.theme.UdemyJetBMICalculatorTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UdemyJetBMICalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        //
                        Text(
                            text = "BMI計算アプリ",
                            color = Color(0xFF7DAF43),
                            fontSize = 26.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Spacer(modifier = Modifier.height(30.dp))

                        // 身長
                        SingleLineTextField(
                            value = viewModel.height,
                            onValueChange = { viewModel.height = it },
                            label = "身長(cm)",
                            placeholder = "170"
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        // 体重
                        SingleLineTextField(
                            value = viewModel.weight,
                            onValueChange = { viewModel.weight = it },
                            label = "体重(kg)",
                            placeholder = "60"
                        )
                        Spacer(modifier = Modifier.height(30.dp))

                        // 計算するボタン
                        Button(
                            onClick = { viewModel.calculateBMI() },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFF7DAF43)
                            ),
                        ) {
                            Text(
                                text = "計算する",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(50.dp))

                        // 計算結果表示
                        Text(
                            text = "あなたのBMIは${viewModel.bmi}です",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}

// テキストフィールド
@Composable
fun SingleLineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String
) {
    Column {
        Text(
            text = label,
            fontWeight = FontWeight.ExtraBold
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(placeholder) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            value = value,
            onValueChange = onValueChange
        )
    }
}
