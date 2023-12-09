package com.example.project_g_kmp.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.project_g_kmp.android.navigation.Destinations.CADASTRO
import com.example.project_g_kmp.android.navigation.Destinations.FEED
import com.example.project_g_kmp.android.navigation.Destinations.LOGIN
import com.example.project_g_kmp.android.navigation.Destinations.PROFILE
import com.example.project_g_kmp.android.navigation.Destinations.PROFILEP
import com.example.project_g_kmp.android.navigation.Destinations.PROJECT
import com.example.project_g_kmp.android.navigation.Destinations.REC
import com.example.project_g_kmp.android.navigation.Destinations.SEARCH
import com.example.project_g_kmp.android.view.Cad
import com.example.project_g_kmp.android.view.Feed
import com.example.project_g_kmp.android.view.Login
import com.example.project_g_kmp.android.view.Profile
import com.example.project_g_kmp.android.view.ProfileP
import com.example.project_g_kmp.android.view.Project
import com.example.project_g_kmp.android.view.Rec
import com.example.project_g_kmp.android.view.Search

object Destinations {
    const val LOGIN = "login"
    const val FEED = "feed"
    const val PROJECT = "project"
    const val PROFILE = "profile"
    const val PROFILEP = "profileP"
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
            Feed(navController)
        }

        composable(PROJECT) {
            Project(navController)
        }

        composable(PROFILE) {
            Profile(navController)
        }

        composable(PROFILEP) {
            ProfileP(navController)
        }


        composable(SEARCH) {
            Search(navController)
        }

        composable(LOGIN) {
            Login(navController)
        }

        composable(REC) {
            Rec(navController)
        }

        composable(CADASTRO) {
            Cad(navController)
        }
    }
}

