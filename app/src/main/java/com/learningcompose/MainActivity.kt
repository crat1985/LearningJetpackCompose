package com.learningcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.learningcompose.ui.theme.LearningComposeTheme
import com.learningcompose.ui.theme.Shapes

class MainActivity : ComponentActivity() {

    //private var i = 0

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                /*Lazy*/Column (
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background).padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    /*SelectionContainer {
                        Column(
                            modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("Hello World", color = MaterialTheme.colors.onBackground)
                            DisableSelection {
                                Text("Texte non sélectionnable !", color = MaterialTheme.colors.onBackground)
                            }
                            Text("suite du texte", color = MaterialTheme.colors.onBackground)
                        }
                    }*/

                    //SuperText(normalText = "Titre de l'application", superText = "Sous-titre")

                    /*ExpandableCardTP(
                        title = "Titre de l'actu",
                        description = "Une description random"
                    )*/

                    /*Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressBar(
                            percentage = 0.8f,
                            number = 100
                        )
                    }*/

                    /*items(5000) {
                        ExpandableCard(description = "azuezu zeu ezu uezhui hrzeui ghuezguheruih uiezhui heruih uierhui geriug fyuezgui fgzerugezuguegzui guetureuthueri htuhreuithuierhtuirehuthreuihtuhuirthuiethuithrihrtuithrui")
                        Spacer(modifier = Modifier.height(16.dp))
                        ExpandableCardTP2(description = "azuezu zeu ezu uezhui hrzeui ghuezguheruih uiezhui heruih uierhui geriug fyuezgui fgzerugezuguegzui guetureuthueri htuhreuithuierhtuirehuthreuihtuhuirthuiethuithrihrtuithrui")
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    var text by remember {
                        mutableStateOf("")
                    }

                    LaunchedEffect(key1 = text) {
                        println("The text is $text")
                        i++
                    }

                    Button(
                        onClick = {
                            text += "#"
                        }
                    ) {
                        Text(text)
                    }

                    SideEffect {
                        println("Successfully recomposed !")
                    }*/

                    //Animations()



                    GoogleButton(onClicked = {
                        Toast.makeText(this@MainActivity, "Successfully created account !", Toast.LENGTH_LONG).show()
                    })

                    CoilImage()

                    PseudoTextField()

                    PasswordTextField("Mot de passe")

                    GradientButton(
                        text = "Hello World",
                        textColor = MaterialTheme.colors.onBackground,
                        gradient = Brush.horizontalGradient(
                            colors = listOf(Color.Blue, Color.Red)
                        )
                    ) {
                        Log.d("Gradient Button", "Clicked !")
                    }

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier
                            .border(10.dp, MaterialTheme.colors.onBackground, Shapes.medium),
                        contentPadding = PaddingValues(10.dp)
                    ) {
                        items(PersonRepository.getAllDatas()) {
                            PersonItem(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SuperText(
    normalText: String,
    normalTextFontSize: TextUnit = MaterialTheme.typography.h1.fontSize,
    textColor: Color = MaterialTheme.colors.onBackground,
    superText: String,
    superTextFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize
) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalTextFontSize,
                    fontWeight = MaterialTheme.typography.h1.fontWeight,
                    color = textColor
                )
            ) {
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = superTextFontSize,
                    color = textColor,
                    baselineShift = BaselineShift.Superscript
                )
            ) {
                append(superText)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperText("Titre", superText = "Sous-titre")
}