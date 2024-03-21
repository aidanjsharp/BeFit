package com.example.befit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
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
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
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
            when (screenNo) {
                1 -> LoginScreen(screenNo = 1)
                2 -> WelcomeScreen(screenNo = 2)
                3 -> HomeScreen(screenNo = 3)
                4 -> CreateAnAccountScreen(screenNo = 4)
                else -> {
                    Text(text = "Error, page not found.")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    BeFitTheme {
        ScreenFrame(screenNo = 1)
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    BeFitTheme {
        ScreenFrame(screenNo = 2)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    BeFitTheme {
        ScreenFrame(screenNo = 3)
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAnAccountScreenPreview() {
    BeFitTheme {
        ScreenFrame(screenNo = 4)
    }
}