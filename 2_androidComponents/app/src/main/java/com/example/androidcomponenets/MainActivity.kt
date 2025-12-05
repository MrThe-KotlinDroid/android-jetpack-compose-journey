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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
                    Components(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Components(modifier: Modifier = Modifier) {

    val myImage = remember {
        mutableIntStateOf(R.drawable.first_image)
    }

    val myButtonStatus = remember {
        mutableStateOf(true)
    }

    val valueOnTextField = remember {
        mutableStateOf("")
    }

    val userInput = remember {
        mutableStateOf("U entered: ")
    }

    val myText = remember {
        mutableStateOf("Hello World")
    }

    val myButtonText = remember {
        mutableStateOf("Do Your Magic")
    }

    val myButtonBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(myImage.intValue),
            "First Image",
            Modifier.size(300.dp),
            contentScale = ContentScale.Fit,
        )

//        if (myButtonStatus.value) {
//        }
        Text(
            text = myText.value,
            color = Color.White,
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(20.dp)
        )

        Spacer(Modifier.size(30.dp))
        Button(
            onClick = {
                if (myButtonStatus.value) {
                    myImage.intValue = R.drawable.second_image
                    myText.value = "Hello Compose!"
                    myButtonText.value = "Compose is fun!"
                    myButtonBackgroundColor.value = Color.Cyan
                    myButtonStatus.value = false
                }
                else{
                    myImage.intValue = R.drawable.first_image
                    myText.value = "Hello World!"
                    myButtonText.value = "Do Your Magic"
                    myButtonBackgroundColor.value = Color.Red
                    myButtonStatus.value = true
                }

                userInput.value = valueOnTextField.value
                valueOnTextField.value = ""
            },
            modifier = Modifier.size(250.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = myButtonBackgroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Text(
                text = myButtonText.value,
                color = Color.White,
                fontSize = 20.sp
            )
        }

        Spacer(Modifier.size(30.dp))

        TextField(
            value = valueOnTextField.value,
            onValueChange = {
                valueOnTextField.value = it
            },
            label = { Text(text = "Enter Your Name") },
            modifier = Modifier
                .width(300.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.Gray,
                focusedLabelColor = Color.Yellow,
                unfocusedLabelColor = Color.White,
                unfocusedIndicatorColor = Color.Red,
                focusedIndicatorColor = Color.White
            ),
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            maxLines = 1
        )

        Spacer(Modifier.size(20.dp))

        Text(
            fontSize = 24.sp,
            text = userInput.value,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(10.dp),
            color = Color.Black
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