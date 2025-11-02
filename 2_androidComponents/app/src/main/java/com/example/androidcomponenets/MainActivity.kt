package com.example.androidcomponenets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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

    val myButtonStatus = remember {
        mutableStateOf(true)
    }

    val valueOnTextField = remember {
        mutableStateOf("")
    }

    val userInput = remember {
        mutableStateOf("Result:")
    }

    val myImage = remember {
        mutableStateOf(R.drawable.first_image)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(myImage.value),
            "First Image",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )

        Spacer(modifier = Modifier.size(10.dp))

        if (myButtonStatus.value) {
            Text(
                text = "Hello Compose",
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(20.dp),
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        Button(
            onClick = {
                if (myButtonStatus.value) {
                    myButtonBackgroundColor.value = Color.Black
                    myButtonText.value = "Compose is Fun"
                    myButtonBorderColor.value = Color.Yellow
                    myImage.value = R.drawable.second_image

                    myButtonStatus.value = false
                } else {
                    myButtonBackgroundColor.value = Color.Red
                    myButtonText.value = "Do Your Magic"
                    myButtonBorderColor.value = Color.Black
                    myImage.value = R.drawable.first_image

                    myButtonStatus.value = true
                }
                userInput.value = valueOnTextField.value
                valueOnTextField.value = ""
            },


            modifier = Modifier.size(250.dp, 60.dp),
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

        Spacer(modifier = Modifier.size(20.dp))

        TextField(
            value = valueOnTextField.value,
            onValueChange = {
                valueOnTextField.value = it
            },
            label = { Text(text = "Enter your name") },
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = Color.Blue,
                focusedLabelColor = Color.Yellow,
                unfocusedLabelColor = Color.White,
                unfocusedIndicatorColor = Color.Red,
                focusedIndicatorColor = Color.Green
            ),
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            maxLines = 4,
            //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            //visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.size(20.dp))

        Text(
            fontSize = 24.sp,
            text = userInput.value,
            modifier = Modifier
                .background(Color.Gray)
                .padding(10.dp),
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidComponenetsTheme {
        Components()
    }
}