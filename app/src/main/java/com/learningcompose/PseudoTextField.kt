package com.learningcompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun PseudoTextField() {
    var pseudoState by rememberSaveable {
        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = pseudoState,
        onValueChange = {
            pseudoState = it
        },
        label = {
            Text("Pseudo")
        },textStyle = TextStyle(
            color = MaterialTheme.colors.onBackground
        ), singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(Icons.Filled.Person, contentDescription = "")
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ) {
                Icon(Icons.Filled.ArrowRightAlt, "")
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            },
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )
}