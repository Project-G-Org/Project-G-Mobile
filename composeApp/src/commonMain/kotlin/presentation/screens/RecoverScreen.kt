package presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import model.InputType
import navigation.screencomponents.RecoverScreenComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.Components.CustomTextInput

@OptIn(ExperimentalResourceApi::class)
@Composable
fun RecoverScreen(component: RecoverScreenComponent) {

    val valueGmail = remember {
        mutableStateOf("")
    }

    val valueVc = remember {
        mutableStateOf("")
    }

    val valuePass = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource("cadback.png"),
                contentScale = ContentScale.FillBounds,
            ),
        contentAlignment = Alignment.Center
    ) {
        Column (
            Modifier
                .padding(all = 24.dp)
                .background(Color(0xFF202020))
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){

            CustomTextInput(InputType.Gmail, value = valueGmail)
            CustomTextInput(InputType.VC, value = valueVc)
            CustomTextInput(InputType.Password, value = valuePass)
            val buttonColor = remember {
                mutableStateOf(Color(0xFFE5684A))
            }
            Button(
                onClick = {buttonColor.value = Color(0xFFE5684A) },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFE5684A)
                ),
                modifier = Modifier
                    .padding(bottom = 12.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Text(
                        text = "Send Gmail",
                        color = Color.White
                    )
                }
            }
        }
    }
}