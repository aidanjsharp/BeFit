package com.example.befit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.befit.ui.theme.BeFitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeFitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenFrame(screenNo = 1)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenFrame(
    modifier: Modifier = Modifier,
    screenNo: Int
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(
                    text = "BeFit.",
                    textAlign = TextAlign.Center
                ) },
                scrollBehavior = scrollBehavior
            )
        }
    ){
        Surface (
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ){
            if (screenNo == 1) {
                LoginScreen()
            } else if (screenNo == 2){
                WelcomeScreen()
            } else if (screenNo == 3){
                HomeScreen()
            } else{
                Text(text = "ERROR.")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    //TopAppBar(title = { "BeFit" })
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(){
            Text(text = "Welcome to BeFit!\n\n")
        }
        UsernameField()

        PasswordField()

        Button(onClick = { /*onClick()*/ }) {
            Text("Log In")
        }
        Button(onClick = { /*onClick()*/ }) {
            Text("Forgot Password")
        }
        Button(onClick = { /*onClick()*/ }) {
            Text("Create an Account")
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(modifier: Modifier = Modifier){
    //TopAppBar(title = { "BeFit" })
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(text = "Please enter your most recent workout:")
            DailyWorkoutField()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    //TopAppBar(title = { "BeFit" })
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(onClick = { /*onClick()*/ }) {
            Text("Refresh")
        }

        LazyColumn(
            modifier = modifier
        ){


        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameField() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Username:") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Password:") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyWorkoutField() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Today's Workout") }
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BeFitTheme {
        ScreenFrame(screenNo = 1)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    BeFitTheme {
        ScreenFrame(screenNo = 2)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    BeFitTheme {
        ScreenFrame(screenNo = 3)
    }
}