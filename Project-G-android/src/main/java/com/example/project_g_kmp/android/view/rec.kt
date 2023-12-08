package com.example.project_g_kmp.android.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.project_g_kmp.android.R

@Composable
fun Rec(){

    Image(
        painter = painterResource(id = R.drawable.cadback),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )

    Column (
        Modifier
            .padding(vertical = 220.dp, horizontal = 24.dp)
            .background( Color(0xFF202020))
            .clip(RoundedCornerShape(18.dp))
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        TextInput(InputTypeRec.Gmail)
        TextInput(InputTypeRec.VC)
        TextInput(InputTypeRec.Password)
        val buttonColor = remember {
            mutableStateOf(Color(0xFFE5684A))
        }
        Button(
            onClick = {buttonColor.value = Color(0xFFE5684A) },
            colors = ButtonDefaults.buttonColors(
                Color(0xFFE5684A)
            )
        )
        {
            Text("Send Gmail",
                Modifier
                    .padding(vertical = 8.dp, horizontal = 50.dp)
                    )
        }

    }



}

sealed class InputTypeRec(
    val label:String,
    val icon: ImageVector,
    val keyboardOptions: KeyboardOptions,
    val visualTransformation: VisualTransformation
) {
    object Gmail : InputType(
        label = "Gmail",
        icon = Icons.Default.Email,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object VC : InputType(label = "Verification Code",
        icon = Icons.Default.Person,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object Password : InputType(label = "New Password",
        icon = Icons.Default.Lock,
        KeyboardOptions(imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )




}

@Composable
@Preview
private fun TestPreview(){

    Rec()
}
