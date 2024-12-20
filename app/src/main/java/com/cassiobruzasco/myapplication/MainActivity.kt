package com.cassiobruzasco.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cassiobruzasco.myapplication.ui.screen.LoginScreen
import com.cassiobruzasco.myapplication.ui.screen.WelcomeScreen
import com.cassiobruzasco.myapplication.ui.theme.MyApplicationTheme

/**
 *
 * Challenge 1:
 *
 * Description:
 * Create a simple Android application with a login screen.
 * The login screen should accept a username and password.
 * Upon entering valid credentials, the user should be redirected to a welcome screen.
 * Ensure that the login process is secure and follows best practices.
 *
 * Requirements:
 * Create a layout for the login screen with EditText fields for username and password,
 * and a login button.
 * Implement validation to ensure that both username and password fields are not empty.
 * Implement a secure authentication mechanism to verify the username and password.
 * You can use hardcoded credentials for simplicity.
 * After successful authentication, navigate the user to a welcome screen displaying a welcome message.
 *
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            LoginScreen(
                                modifier = Modifier.fillMaxSize().padding(innerPadding),
                                goToWelcome = {
                                    navController.navigate("welcome")
                                }
                            )
                        }
                        composable("welcome") {
                            WelcomeScreen(
                                modifier = Modifier.fillMaxSize().padding(innerPadding)
                            )
                        }
                    }

                }
            }
        }
    }
}

