package com.example.project_g_kmp.android.view

import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

data class DropDownItem(
    val text: String
)
@Composable
fun coment(
    label: String,
    dropDownItems: List<DropDownItem>,
    comente: String,
    modifier: Modifier,
    onItemClick: (DropDownItem) -> Unit
) {
    var isCosntexMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }
}