package com.example.project_g_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform