package com.cassiobruzasco.myapplication.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.myapplication.ui.theme.MyApplicationTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    goToWelcome: () -> Unit = {}
) {
    var username by remember { mutableStateOf("Cassio") }
    var password by remember { mutableStateOf("Test123") }

    val usernameError by remember {
        derivedStateOf {
            username.isEmpty()
        }
    }

    val passwordError by remember {
        derivedStateOf {
            password.isEmpty()
        }
    }

    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "Login Screen",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge
        )

        if (usernameError || passwordError) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                text = "Username or Password should not be empty",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Red
            )
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            value = username,
            placeholder = {
                Text("Username")
            },
            isError = usernameError,
            onValueChange = { username = it }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            value = password,
            placeholder = {
                Text("Password")
            },
            isError = passwordError,
            onValueChange = { password = it }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            onClick = {
                goToWelcome()
            },
            enabled = !usernameError && !passwordError
        ) {
            Text("Login")
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun LoginPreview() {
    MyApplicationTheme {
        LoginScreen()
    }
}