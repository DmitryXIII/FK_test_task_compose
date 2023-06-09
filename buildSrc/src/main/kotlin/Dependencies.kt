object Dependencies {
    object Android {
        private const val coreKtxVersion = "1.10.1"
        private const val lifecycleRuntimeKtxVersion = "2.6.1"
        private const val kotlinBomVersion = "1.8.0-RC2"
        private const val swipeRefreshVersion = "0.31.3-beta"

        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeKtxVersion"
        const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:$kotlinBomVersion"
        const val swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:$swipeRefreshVersion"
    }

    object Compose {
        private const val activityComposeVersion = "1.7.2"
        private const val composeBomVersion = "2023.05.01"
        private const val composeLiveDataVersion = "1.5.0-beta02"
        private const val composeNavigationVersion = "2.6.0"
        private const val composeNavigationAnimationVersion = "0.31.2-alpha"

        const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
        const val composeBom = "androidx.compose:compose-bom:$composeBomVersion"
        const val composeUi = "androidx.compose.ui:ui"
        const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val composeMaterial = "androidx.compose.material3:material3"
        const val composeUiTestJUnit = "androidx.compose.ui:ui-test-junit4"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling"
        const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
        const val composeLiveData = "androidx.compose.runtime:runtime-livedata:$composeLiveDataVersion"
        const val composeNavigation = "androidx.navigation:navigation-compose:$composeNavigationVersion"
        const val composeNavigationAnimation = "com.google.accompanist:accompanist-navigation-animation:$composeNavigationAnimationVersion"
    }

    object Test {
        private const val junitVersion = "4.13.2"
        private const val testExtJunitVersion = "1.1.5"
        private const val testEspressoVersion = "3.5.1"

        const val junit = "junit:junit:$junitVersion"
        const val testExtJunit = "androidx.test.ext:junit:$testExtJunitVersion"
        const val testEspresso = "androidx.test.espresso:espresso-core:$testEspressoVersion"
    }

    object Retrofit {
        private const val RETROFIT_2_VER = "2.9.0"
        private const val RETROFIT_2_CONVERTER_GSON_VER = "2.9.0"
        private const val LOGGING_INTERCEPTOR_VER = "4.9.3"
        private const val COROUTINE_ADAPTER_VER = "0.9.2"

        const val RETROFIT_2 = "com.squareup.retrofit2:retrofit:$RETROFIT_2_VER"
        const val RETROFIT_2_CONVERTER_GSON =
            "com.squareup.retrofit2:converter-gson:$RETROFIT_2_CONVERTER_GSON_VER"
        const val LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:$LOGGING_INTERCEPTOR_VER"
        const val COROUTINE_ADAPTER =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$COROUTINE_ADAPTER_VER"
    }

    object Room {
        private const val ROOM_VER = "2.4.3"

        const val ROOM_RUNTIME = "androidx.room:room-runtime:$ROOM_VER"
        const val ROOM_COMPILER = "androidx.room:room-compiler:$ROOM_VER"
        const val ROOM_KTX = "androidx.room:room-ktx:$ROOM_VER"
    }

    object Hilt {
        private const val HILT_VER = "2.46.1"
        private const val HILT_NAV_COMPOSE_VER = "1.0.0"

        const val HILT_ANDROID = "com.google.dagger:hilt-android:$HILT_VER"
        const val HILT_COMPILER = "com.google.dagger:hilt-compiler:$HILT_VER"
        const val HILT_NAVIGATION_COMPOSE =
            "androidx.hilt:hilt-navigation-compose:$HILT_NAV_COMPOSE_VER"
    }
}