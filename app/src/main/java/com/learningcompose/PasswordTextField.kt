package com.learningcompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordTextField(
    passwordLabel: String
) {
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var hidden by rememberSaveable {
        mutableStateOf(true)
    }

    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        modifier = Modifier
            .fillMaxWidth(),
        label = {
            Text(text = passwordLabel)
        },
        /*placeholder = {
            Text(text = "Mot de passe")
        },*/
        textStyle = TextStyle(
            color = MaterialTheme.colors.onBackground
        ),
        singleLine = true,
        leadingIcon = {
                      Icon(Icons.Filled.Password, "Password Icon")
        },
        trailingIcon = {
            IconButton(
                {
                    hidden = !hidden
                }
            ) {
                Icon(
                    if(hidden) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    "Visibility Icon"
                )
            }
        },
        visualTransformation = if(hidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        )
    )
}