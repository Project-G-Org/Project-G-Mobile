package presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.center
import androidx.compose.ui.unit.dp
import model.InputType
import navigation.screencomponents.CadastroScreenComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.Components.CustomTextInput

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CadastroScreen(component: CadastroScreenComponent) {

    var showContent by remember {
        mutableStateOf(false)
    }

    val name = remember {
        mutableStateOf("")
    }

    val gmail = remember {
        mutableStateOf("")
    }

    val pass = remember {
        mutableStateOf("")
    }

    val passConfirm = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource("cadback.png"),
                contentScale = ContentScale.FillBounds
            )
            .clip(shape = RoundedCornerShape(14.dp))
            .padding(vertical = 24.dp, horizontal = 24.dp),
    ) {
        LaunchedEffect(Unit) {
            showContent = true
        }
        AnimatedVisibility(
            visible = showContent,
            enter = slideInHorizontally(animationSpec = tween(800))
        ) {

            CardFields(component, name, gmail, pass, passConfirm)
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun CardFields(
    component: CadastroScreenComponent,
    name: MutableState<String>,
    gmail: MutableState<String>,
    pass: MutableState<String>,
    passConfirm: MutableState<String>
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = Color(0xFF202020)
    ) {


        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(
                16.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            )
            {
                Button(
                    onClick = {
                        component.goBack()
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xE5684A),
                    ),
                    modifier = Modifier
                        .padding(start = 20.dp, top = 20.dp)
                ) {
                    Icon(
                        painter = painterResource("baseline_back_24.xml"),
                        contentDescription = null,
                        Modifier
                            .size(30.dp),
                        tint = Color.White
                    )
                }
            }



            CustomTextInput(inputType = InputType.Name, value = name)
            CustomTextInput(inputType = InputType.Gmail, value = gmail)
            CustomTextInput(inputType = InputType.Password, value = pass)
            CustomTextInput(inputType = InputType.CPassword, value = passConfirm)

            val buttonColor = remember {
                mutableStateOf(Color.Red)
            }
            Button(
                onClick = { buttonColor.value = Color.Gray },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFE5684A),
                )
            ) {
                Text(
                    "Cadastrar-se",
                    Modifier.padding(vertical = 8.dp, horizontal = 50.dp),
                    color = Color.White
                )
            }
            Divider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(top = 30.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Já tem uma conta?", color = Color.White)
                TextButton(onClick = {
                    component.goBack()
                }) {
                    Text("Clique aqui", color = Color(0xFFE5684A))
                }
            }
        }
    }
}