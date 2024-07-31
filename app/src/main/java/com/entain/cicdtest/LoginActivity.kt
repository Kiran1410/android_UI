package com.entain.cicdtest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.entain.cicdtest.ui.theme.CICDTestTheme

class LoginActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CICDTestTheme {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    var (username,setUsername) = remember { mutableStateOf("") }
                    var (password, setPassword) = remember { mutableStateOf("") }

                    SimpleOutlinedTextFieldSample(Modifier.testTag("usernameInput"),"username", username, setUsername)
                    SimpleOutlinedTextFieldSample(Modifier.testTag("passwordInput"),"password", password, setPassword)
                    FilledButtonExample(onClick = {
                        if(username.equals("rishi") && password.equals("panchal")){
                            val mainIntent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(mainIntent)
                        }
                    })
                }
            }
        }
    }

    @Composable
    fun SimpleOutlinedTextFieldSample(modifier: Modifier, label: String, value: String, setvalue: (String) -> Unit) {

        OutlinedTextField(
            value = value,
            onValueChange = { newText -> setvalue(newText) },
            label = { Text(label) },
            modifier = modifier
        )
    }

    @Composable
    fun FilledButtonExample(onClick: () -> Unit) {
        Button(onClick = { onClick() },
            modifier = Modifier.testTag("loginButton")) {
            Text("Login")
        }
    }
}