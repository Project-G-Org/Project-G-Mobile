package com.example.project_g_kmp.android.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project_g_kmp.android.R


@Composable
fun Cad(navController: NavController,){

    Image(painter = painterResource(id = R.drawable.cadback),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            )

    Column (
        Modifier
            .padding(vertical = 110.dp, horizontal = 24.dp)
            .background(Color(0xFF202020))
            .border( width = 0.dp,
                color = Color(0xFF202020),
                shape = RoundedCornerShape(18.dp))
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Column(
            Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start){
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    Color(0xE5684A),
                )
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_back_24)
                    , contentDescription = null
                    , Modifier
                        .size(30.dp))
            }
        }



        TextInput(InputTypeCad.Name)
        TextInput(InputTypeCad.Gmail)
        TextInput(InputTypeCad.Password)
        TextInput(InputTypeCad.CPassword)
        val buttonColor = remember {
            mutableStateOf(Color.Red)
        }
        Button(
            onClick = {buttonColor.value = Color.Gray },
            colors = ButtonDefaults.buttonColors(
                Color(0xFFE5684A),
            )
        )
        {
            Text("Login",
                Modifier.padding(vertical = 8.dp, horizontal = 50.dp)
            )
        }
        Divider(color = Color.White.copy(alpha = 0.3f),
            thickness = 1.dp,
            modifier = Modifier.padding(top = 30.dp,)
        )
        Row(verticalAlignment = Alignment.CenterVertically){
            Text("ja tem uma  conta?", color = Color.White)
            TextButton(onClick = {}) {
                Text("clique aqui", color = Color(0xFFE5684A),)
            }
        }
    }

}

sealed class InputTypeCad(
) {
    object Name : InputType(
        label = "User Name",
        icon = Icons.Default.Person,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )

    object Gmail : InputType(
        label = "Gmail",
        icon = Icons.Default.Email,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object Password : InputType(
        label = "Password",
        icon = Icons.Default.Lock,
        KeyboardOptions(imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )
    object CPassword : InputType(
        label = "Confirm Password",
        icon = Icons.Default.Lock,
        KeyboardOptions(imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )

}
