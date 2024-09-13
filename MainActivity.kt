package com.example.randomtrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.randomtrivia.ui.theme.RandomTriviaTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomTriviaTheme {
                //Put Composables here
                var fact = remember {
                    mutableStateOf(ranTrivia())
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = fact.value,
                        fontSize = 30.sp,
                        color = Color.Blue

                    )
                    Button(
                        onClick = { fact.value = ranTrivia() },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                    ) {
                        Text(text="Next Fact")
                    }
                }
            }
        }
    }
}

fun ranTrivia() : String {
    val index = Random.nextInt(0,5)
    val facts = arrayOf(
        "A cloud weighs around a million tonnes.",
        "Giraffes are 30 times more likely to get hit by lightning than people.",
        "The fear of long words is called Hippopotomonstrosesquippedaliophobia.",
        "The world’s oldest cat lived to 38 years and three days old.",
        "Our solar system has a wall. The heliopause",
        "The T.rex likely had feathers.")
    return facts[index]
}