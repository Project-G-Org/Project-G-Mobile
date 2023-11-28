plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("io.coil-kt:coil-compose:2.4.0")

                implementation("com.google.accompanist:accompanist-insets:0.23.1")

                implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

                implementation("com.google.android.exoplayer:exoplayer-core:2.19.1")
                implementation("com.google.android.exoplayer:exoplayer-ui:2.19.1")

                implementation ("com.google.accompanist:accompanist-pager:0.28.0")
                implementation ("com.google.accompanist:accompanist-pager-indicators:0.28.0")

                implementation("androidx.navigation:navigation-compose:2.5.3")
                implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")


                implementation(projects.shared)
                implementation(libs.compose.ui)
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.compose.material3)
                implementation(libs.androidx.activity.compose)
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "com.example.project_g_kmp"
    compileSdk = 34
    defaultConfig {
        minSdk = 27
    }
}
