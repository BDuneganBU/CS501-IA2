package com.example.advancedgreetings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import com.example.advancedgreetings.ui.theme.AdvancedGreetingsTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdvancedGreetingsTheme {
                //Value to store the field data
                var field = remember {
                    mutableStateOf("")
                }
                //Value to store the last enterd name
                var name = remember {
                    mutableStateOf("")
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    OutlinedTextField(
                        value = field.value,
                        onValueChange = { text ->
                            field.value = text
                        }
                    )
                    Button(onClick = {
                        if (field.value.isNotBlank()) {
                            name.value = greeting() + field.value
                        }
                    }) {
                        Text(text = "Submit")
                    }
                    Text(
                        text = name.value,
                        color = Color.Blue,
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}

//Function to return the time-appropriate greeting
fun greeting(): String {
    val current = LocalTime.now()

    if (current <= LocalTime.of(12, 0)) {
        return "Good Morning, "
    } else if (current <= LocalTime.of(16, 0)) {
        return "Good Afternoon, "
    } else if (current <= LocalTime.of(22, 0)){
        return "Good Evening, "
    } else {
        return "Go to sleep, "
    }
}
