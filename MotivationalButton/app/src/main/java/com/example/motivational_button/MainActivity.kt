package com.example.motivational_button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.motivational_button.ui.theme.MotivationalButtonTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotivationalButtonTheme {
                    var index = remember {
                        mutableStateOf(true)
                    }
                    //Put Composables here
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = quote(index.value),
                            fontSize = 30.sp,
                            color = Color.Black
                        )
                        Button(onClick = {
                                index.value = !index.value
                        }) {
                            Text(text="Need Motivation?")
                        }
                    }
                }
            }
        }
    }

fun quote(index: Boolean) : String {
    if(index) {
        return "Carpe Diem!"
    } else {
        return "You got this!"
    }
}