package com.example.androidcomponenets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomponenets.ui.theme.AndroidComponenetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComponenetsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Components()
                    }
                }
            }
        }
    }
}

@Composable
fun Components() {

    val myButtonBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }

    val myButtonText = remember {
        mutableStateOf("Do Your Magic")
    }

    val myButtonBorderColor = remember {
        mutableStateOf(Color.Black)
    }

    val myText = remember {
        mutableStateOf("Hello World")
    }

    val myButtonStatus = remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = myText.value,
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(20.dp),
            color = Color.White
        )

        Spacer(modifier = Modifier.size(30.dp))

        Button(
            onClick = {
                if (myButtonStatus.value) {
                    myButtonBackgroundColor.value = Color.Black
                    myButtonText.value = "Nice Magic!"
                    myButtonBorderColor.value = Color.Yellow
                    myText.value = "Hello Compose"

                    myButtonStatus.value = false
                } else {
                    myButtonBackgroundColor.value = Color.Red
                    myButtonText.value = "Do Your Magic"
                    myButtonBorderColor.value = Color.Black
                    myText.value = "Hello World"

                    myButtonStatus.value = true
                }
            }, modifier = Modifier.size(250.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = myButtonBackgroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, myButtonBorderColor.value)
        ) {
            Text(
                text = myButtonText.value,
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidComponenetsTheme {
        Components()
    }
}