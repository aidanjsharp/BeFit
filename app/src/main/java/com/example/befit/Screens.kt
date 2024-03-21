package com.example.befit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/****************SCREENS WITHIN PRIMARY SCAFFOLD****************/
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    screenNo: Int
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = modifier.padding(all = 10.dp)
        ){
            Text(
                text = "Welcome to BeFit!",
                modifier = modifier.padding(all = 20.dp)
            )
        }
        UsernameField()

        PasswordField()

        Button(
            onClick = { /*screenNo = 2*/ },
            modifier = modifier.padding(all = 4.dp)
        ) {
            Text("Log In")
        }

        Row {
            /*Button(
                onClick = { *//*onClick()*//* },
                modifier = modifier.padding(all = 4.dp)
            ) {
                Text("Forgot Password")
            }*/
            Button(
                onClick = { /*onClick()*/ },
                modifier = modifier.padding(all = 4.dp)
            ) {
                Text("Create an Account")
            }
        }
    }
}

@Composable
fun CreateAnAccountScreen(
    modifier: Modifier = Modifier,
    screenNo: Int
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Enter a username",
            modifier = modifier.padding(all = 20.dp)
        )
        UsernameField()

        Text(
            text = "Enter a Password",
            modifier = modifier.padding(all = 20.dp)
        )
        PasswordField()

        Text(
            text = "Confirm Password",
            modifier = modifier.padding(all = 20.dp)
        )
        PasswordField()

        Row {
            Button(
                onClick = { /*onClick()*/ },
                modifier = modifier.padding(all = 4.dp)
            ) {
                Text("Back")
            }
            Button(
                onClick = { /*onClick()*/ },
                modifier = modifier.padding(all = 4.dp)
            ) {
                Text("Next")
            }
        }
    }
}

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    screenNo: Int
){
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(
            onClick = { /*onClick()*/ },
            modifier = modifier.padding(all = 4.dp)
        ) {
            Text("Log Out")
        }

        Text(text = "Please enter your most recent workout:")
        DailyWorkoutField()
    }
}
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    screenNo: Int
){
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            Button(
                onClick = { /*onClick()*/ },
                modifier = modifier.padding(all = 4.dp)
            ) {
                Text("Refresh")
            }
            Button(
                onClick = { /*onClick()*/ },
                modifier = modifier.padding(all = 4.dp)
            ) {
                Text("Log Out")
            }
        }


        LazyColumn(
            modifier = modifier
        ){


        }
    }
}







/****************INPUT FIELDS****************/

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