@file:Suppress("UnstableApiUsage", "suppressKotlinVersionCompatibilityCheck")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "ru.avacodo.fktesttaskcompose"
    compileSdk = 33

    defaultConfig {
        applicationId = "ru.avacodo.fktesttaskcompose"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
}

dependencies {
    implementation (Dependencies.Hilt.HILT_ANDROID)
    kapt (Dependencies.Hilt.HILT_COMPILER)
    implementation (Dependencies.Hilt.HILT_NAVIGATION_COMPOSE)

    implementation(Dependencies.Android.coreKtx)
    implementation(platform(Dependencies.Android.kotlinBom))
    implementation(Dependencies.Android.lifecycleRuntimeKtx)
    implementation(Dependencies.Android.swipeRefresh)
    implementation(Dependencies.Android.systemUIController)

    implementation(Dependencies.Compose.activityCompose)
    implementation(platform(Dependencies.Compose.composeBom))
    implementation(Dependencies.Compose.composeUi)
    implementation(Dependencies.Compose.composeUiGraphics)
    implementation(Dependencies.Compose.composeUiToolingPreview)
    implementation(Dependencies.Compose.composeMaterial)
    implementation(Dependencies.Compose.composeLifeCycle)
    implementation(Dependencies.Compose.composeNavigation)
    implementation(Dependencies.Compose.composeNavigationAnimation)

    implementation(Dependencies.Retrofit.RETROFIT_2)
    implementation(Dependencies.Retrofit.RETROFIT_2_CONVERTER_GSON)
    implementation(Dependencies.Retrofit.LOGGING_INTERCEPTOR)
    implementation(Dependencies.Retrofit.COROUTINE_ADAPTER)

    implementation(Dependencies.Room.ROOM_RUNTIME)
    kapt( Dependencies.Room.ROOM_COMPILER)
    implementation(Dependencies.Room.ROOM_KTX)

    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.testExtJunit)
    androidTestImplementation(Dependencies.Test.testEspresso)

    androidTestImplementation(platform(Dependencies.Compose.composeBom))
    androidTestImplementation(Dependencies.Compose.composeUiTestJUnit)
    debugImplementation(Dependencies.Compose.composeUiTooling)
    debugImplementation(Dependencies.Compose.composeUiTestManifest)
}