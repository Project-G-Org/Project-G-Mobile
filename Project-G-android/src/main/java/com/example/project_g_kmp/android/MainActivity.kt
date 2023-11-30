package com.example.project_g_kmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.project_g_kmp.android.navigation.MainNavigation
import com.example.project_g_kmp.android.view.Feed
import com.example.project_g_kmp.android.view.Login
import com.example.project_g_kmp.android.view.Profile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MainNavigation(navController = navController)
        }
    }
}

@Composable
@Preview
private fun Preview(){

    Profile()
}