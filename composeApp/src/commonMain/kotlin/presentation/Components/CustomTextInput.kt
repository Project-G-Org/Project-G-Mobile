package presentation.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import model.InputType

@Composable
fun CustomTextInput(
    inputType: InputType,
    value: MutableState<String>,
    showError: Boolean = false,
    errorMessage: String = "Este campo não deve estar vazio!"
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        value = value.value,
        onValueChange = { value.value = it },
        leadingIcon = {
            Icon(
                imageVector = inputType.icon,
                contentDescription = null
            )
        },
        label = { Text(text = inputType.label) },
        singleLine = true,
        keyboardOptions = inputType.keyboardOptions,
        visualTransformation = inputType.visualTransformation,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            disabledTextColor = Color.White,
            cursorColor = Color(0xFF74CC3D),
            focusedBorderColor = Color(0xFF74CC3D),
            unfocusedBorderColor = Color(0xFFF06D4D),
            focusedLabelColor = Color(0xFFF06D4D),
            unfocusedLabelColor = Color(0xFFF06D4D),
            leadingIconColor = Color(0xFF74CC3D),
        ),
        isError = showError,
    )
}
