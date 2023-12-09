package com.example.project_g_kmp.android.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.project_g_kmp.android.navigation.Destinations

@Composable
fun TextInput(inputType: InputType) {
    var value by remember { mutableStateOf("")}
    TextField(
        value = value,
        onValueChange = { value = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        leadingIcon = { Icon(imageVector = inputType.icon,
            null)},
        label = { Text(text = inputType.label)},
        singleLine = true,
        keyboardOptions = inputType.keyboardOptions,
        visualTransformation = inputType.visualTransformation,
    )
}
@Composable
fun Login(navController: NavController,){

    Image(painter = painterResource(id = R.drawable.backlogin),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Red)
            )
    Column (
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.logo ),
            null,
            Modifier
                .height(200.dp)
                .width(400.dp)
                .padding(bottom = 50.dp),
        )
        TextInput(InputType.Name)
        TextInput(InputType.Password)
        val buttonColor = remember {
            mutableStateOf(Color(0xFFE5684A))
        }
        Button(
            onClick = {navController.navigate(Destinations.PROFILE)},
            colors = ButtonDefaults.buttonColors(
                Color(0xFFE5684A)
            ))
        {
            Text("Login",
                Modifier
                    .padding(vertical = 8.dp, horizontal = 40.dp)
            )

        }
        Divider(color = Color.White.copy(alpha = 0.3f),
            thickness = 1.dp,
            modifier = Modifier.padding(top = 48.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically){
            Text("nao tem conta?", color = Color.White)
            TextButton(onClick = {}) {
                Text("clique aqui", color =Color(0xFFE5684A))
            }
        }
    }

}

sealed class InputType(
    val label:String,
    val icon:ImageVector,
    val keyboardOptions: KeyboardOptions,
    val visualTransformation: VisualTransformation
) {
    object Name : InputType(label = "User Name",
        icon = Icons.Default.Person,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object Password : InputType(label = "Password",
        icon = Icons.Default.Lock,
        KeyboardOptions(imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )


}
