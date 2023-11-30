package model

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

sealed class InputType(
    val label:String,
    val icon: ImageVector,
    val keyboardOptions: KeyboardOptions,
    val visualTransformation: VisualTransformation
) {
    object Name : InputType(label = "User Name",
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

    object Password : InputType(label = "Password",
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

    object VC : InputType(label = "Verification Code",
        icon = Icons.Default.Person,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
}
