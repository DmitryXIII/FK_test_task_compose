@file:Suppress("UnstableApiUsage", "suppressKotlinVersionCompatibilityCheck")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
}

dependencies {
    implementation(Dependencies.Android.coreKtx)
    implementation(platform(Dependencies.Android.kotlinBom))
    implementation(Dependencies.Android.lifecycleRuntimeKtx)

    implementation(Dependencies.Compose.activityCompose)
    implementation(platform(Dependencies.Compose.composeBom))
    implementation(Dependencies.Compose.composeUi)
    implementation(Dependencies.Compose.composeUiGraphics)
    implementation(Dependencies.Compose.composeUiToolingPreview)
    implementation(Dependencies.Compose.composeMaterial)

    implementation(Dependencies.Retrofit.RETROFIT_2)
    implementation(Dependencies.Retrofit.RETROFIT_2_CONVERTER_GSON)
    implementation(Dependencies.Retrofit.LOGGING_INTERCEPTOR)

    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.testExtJunit)
    androidTestImplementation(Dependencies.Test.testEspresso)

    androidTestImplementation(platform(Dependencies.Compose.composeBom))
    androidTestImplementation(Dependencies.Compose.composeUiTestJUnit)
    debugImplementation(Dependencies.Compose.composeUiTooling)
    debugImplementation(Dependencies.Compose.composeUiTestManifest)
}