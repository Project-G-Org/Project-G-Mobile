package presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import model.InputType
import navigation.screencomponents.LoginScreenComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.Components.CustomTextInput

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoginScreen(component: LoginScreenComponent) {

    val showContent by component.showAnimation.subscribeAsState()
    val coroutineScope = rememberCoroutineScope()

    val valueLogin = remember {
        mutableStateOf("")
    }

    val valuePass = remember {
        mutableStateOf("")
    }

    val buttonColor = remember {
        mutableStateOf(Color(0xFFE5684A))
    }

    var showProgressBar by remember {
        mutableStateOf(false)
    }

    Box(
      modifier = Modifier
          .fillMaxSize()
          .paint(
              painterResource("backlogin.png"),
              contentScale = ContentScale.FillBounds
          )
    ) {

        ShowLoader(showProgressBar, component)

        AnimatedVisibility(
            visible = showContent,
            enter = slideInVertically(animationSpec = tween(700))
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Bottom),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource("logo.png"),
                    contentDescription = null,
                    modifier = Modifier
                        .width(400.dp)
                        .height(200.dp),
                )
                CustomTextInput(inputType = InputType.Name, value = valueLogin)
                CustomTextInput(inputType = InputType.Password, value = valuePass)
                Button(
                    onClick = {
                        //buttonColor.value = Color(0xFFE5684A)
                        showProgressBar = true
                        coroutineScope.launch {
                            delay(2000)
                            component.goToFeed()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFE5684A)
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ExitToApp,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Login",
                            modifier = Modifier
                                .padding(vertical = 8.dp),
                            color = Color.White
                        )
                    }

                }
                Divider(
                    color = Color.White.copy(alpha = 0.3f),
                    thickness = 1.dp,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Não tem conta?", color = Color.White)
                    TextButton(onClick = {
                        component.goToCadastroScreen()
                    }) {
                        Text("Cadastre-se agora", color = Color(0xFFE5684A))
                    }
                }
            }
        }
    }
}

@Composable
private fun ShowLoader(
    showProgressBar: Boolean,
    component: LoginScreenComponent
) {
    if (showProgressBar) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                color = Color(0xFF74CC3D)
            )
        }
    }
    LaunchedEffect(Unit) {
        component.updateShowAnimation(true)
    }
}