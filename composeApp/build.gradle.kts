import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    kotlin("plugin.serialization") version "1.9.21"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(libs.compose.ui)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.decompose)
            implementation("io.ktor:ktor-client-android:2.3.6")
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            implementation ("com.google.accompanist:accompanist-pager:0.28.0")
            implementation ("com.google.accompanist:accompanist-pager-indicators:0.28.0")

            // Decompose
            implementation(libs.decompose)
            implementation(libs.decompose.jetbrains)

            // Kotlinx Serialization
            implementation(libs.kotlinx.serialization.json)

            // KTOR
            implementation("io.ktor:ktor-client-content-negotiation:2.3.6")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.6")
            api("dev.icerock.moko:mvvm-core:0.16.1")
            api("dev.icerock.moko:mvvm-compose:0.16.1")

            // KAMEL

            implementation("media.kamel:kamel-image:0.9.0")
            implementation("io.ktor:ktor-client-core:2.3.6")
        }
        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.6")
        }
    }
}

android {
    namespace = "org.example.mybirdapp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.example.mybirdapp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}
dependencies {
    implementation(libs.androidx.material3)
}

