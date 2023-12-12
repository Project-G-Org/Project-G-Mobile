package com.example.project_g_kmp.android.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class Like : ViewModel() {

   private val _num = mutableStateOf(0)
    val num : State<Int> = _num

    fun addLike(){
        _num.value = _num.value + 1
    }
}