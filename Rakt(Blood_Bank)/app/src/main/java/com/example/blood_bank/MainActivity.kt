package com.example.blood_bank

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ) {
                Image(painterResource(id = R.drawable.logo), contentDescription = "logo")
                Text(
                    text = "RAKT",
                    color = Color.Red,
                    fontFamily = FontFamily(Font(R.font.robotobold)),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Be the reason for someone’s heartbeat",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(
                        Font(R.font.robotobold)
                    )
                )
                Button(
                    onClick = {
                        Intent(this@MainActivity, login::class.java).also { startActivity(it) }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(
                        text = "Sign In",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
                Button(onClick = {
                    Intent(this@MainActivity, Create::class.java).also { startActivity(it) }
                }, colors = ButtonDefaults.buttonColors(Color.Red)) {
                    Text(
                        text = "Create Account",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(top = 120.dp)
                ) {
                    Text(text = "Help with Sign Up or Sign In",
                        fontFamily = FontFamily(Font(R.font.robotobold)),
                        modifier = Modifier
                            .clickable { Color.Blue },
                        textDecoration = TextDecoration.Underline,
                        color = Color.DarkGray)
                }

            }
        }
    }
}

