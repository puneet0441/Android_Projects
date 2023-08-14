package com.example.blood_bank

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import java.time.LocalDate
import java.util.Date

class Create : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainscreen()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun mainscreen() {
    scaff()
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaff() {
    Scaffold(
        topBar = { mytopbar() },
        bottomBar = { mybottombar() },
        content = { h -> mycontent(h)}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mytopbar() {
    TopAppBar(
        title = { Text(text = "Rakt",
            fontFamily = FontFamily(Font(R.font.robotobold)),
            fontSize = 30.sp,
            color = Color.White) },
        navigationIcon = {
            Image(
                painterResource(id = R.drawable.logo),
                contentDescription = "logo", modifier = Modifier.size(60.dp)
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(Color.Red),
        modifier = Modifier.drawBehind {
            drawLine(
                color = Color.Black,
                Offset(0f,size.height),
                Offset(size.width,size.height),
                strokeWidth = 3f
            )
        }
    )
}

@Composable
fun mybottombar() {
    BottomAppBar(
        contentPadding = PaddingValues(5.dp),
        containerColor = Color.White,
        contentColor = Color.Red,
        modifier = Modifier.drawBehind {
            drawLine(
                color = Color.Black,
                Offset(0f, 0f),
                Offset(size.width, 0f),
                strokeWidth = 3f
            )
        }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home",
                modifier = Modifier
                    .size(35.dp)
                    .clickable(onClick = {
                        Intent(LocalContext@ComponentActivity(), MainActivity::class.java)
                    })
            )
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "Home",
                modifier = Modifier
                    .size(35.dp)
                    .clickable { }
            )
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Home",
                modifier = Modifier
                    .size(35.dp)
                    .clickable { }
            )
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Home",
                modifier = Modifier
                    .size(35.dp)
                    .clickable { }
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun mycontent(padding: PaddingValues) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .padding(padding)
                .consumedWindowInsets(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            var name = remember {
                mutableStateOf(TextFieldValue())
            }
            var age = remember {
                mutableStateOf(TextFieldValue())
            }
            var pickDate = remember {
                mutableStateOf(LocalDate.now())
            }
            var isdatepicker = remember {
                mutableStateOf(false)
            }
            Text(
                text = "NAME",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(
                    Font(R.font.robotobold)
                )
            )
            TextField(
                value = name.value, onValueChange = { name.value = it }, modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "DATE OF BIRTH",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(5.dp),
                fontFamily = FontFamily(
                    Font(R.font.robotobold)
                )
            )
            mydatepicker()
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "BLOOD GROUP",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(5.dp),
                fontFamily = FontFamily(
                    Font(R.font.robotobold)
                )
            )
            mydropdown()


        }
    }
}
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun mydropdown() {
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val mCities = listOf("O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(10.dp)) {

        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = {Text("Blood Group", color = Color.Red)},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )
        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            mCities.forEach {
                    label -> DropdownMenuItem(onClick = {
                mSelectedText = label
                mExpanded = false},
                text = { Text(text = label)})
            }
        }
    }
}


@Composable
fun mydatepicker() {
    val showDatePick = remember {
        mutableStateOf(false)
    }
    val date = remember {
        mutableStateOf("")
    }
    val day: Int
    val month: Int
    val year: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val datePickerDialog =
        DatePickerDialog(
            LocalContext.current,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                date.value = "$dayOfMonth/${month+1}/$year"
            }, year, month, day
        )

    Button(
        onClick = { showDatePick.value = true },
        colors = ButtonDefaults.buttonColors(Color.Red)
    ) {
        Text(text = "Click Here to Select DOB", color = Color.White, fontWeight = FontWeight.Bold, fontFamily = FontFamily(
            Font(R.font.robotobold)
        )
        )
    }
    if(showDatePick.value){
        datePickerDialog.show()
        Text(text = "Selected Date: "+"${date.value}", fontSize = 12.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily(
            Font(R.font.robotobold)
        ) )
    }
}

