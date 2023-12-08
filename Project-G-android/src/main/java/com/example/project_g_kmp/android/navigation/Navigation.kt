package com.example.project_g_kmp.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.project_g_kmp.android.navigation.Destinations.CADASTRO
import com.example.project_g_kmp.android.navigation.Destinations.FEED
import com.example.project_g_kmp.android.navigation.Destinations.LOGIN
import com.example.project_g_kmp.android.navigation.Destinations.PROFILE
import com.example.project_g_kmp.android.navigation.Destinations.REC
import com.example.project_g_kmp.android.navigation.Destinations.SEARCH
import com.example.project_g_kmp.android.view.Cad
import com.example.project_g_kmp.android.view.Feed
import com.example.project_g_kmp.android.view.Login
import com.example.project_g_kmp.android.view.Profile
import com.example.project_g_kmp.android.view.Rec
import com.example.project_g_kmp.android.view.Search

object Destinations {
    const val LOGIN = "login"
    const val FEED = "feed"
    const val PROFILE = "profile"
    const val SEARCH = "search"
    const val REC = "rec"
    const val CADASTRO ="cad"
}

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = FEED
    ) {
        composable(FEED) {
            Feed()
        }

        composable(PROFILE) {
            Profile()
        }

        composable(SEARCH) {
            Search()
        }

        composable(LOGIN) {
            Login()
        }

        composable(REC) {
            Rec()
        }

        composable(CADASTRO) {
            Cad()
        }
    }
}

