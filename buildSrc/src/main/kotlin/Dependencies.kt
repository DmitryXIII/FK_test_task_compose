object Dependencies {
    object Android {
        private const val coreKtxVersion = "1.10.1"
        private const val lifecycleRuntimeKtxVersion = "2.6.1"
        private const val kotlinBomVersion = "1.8.0-RC2"

        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeKtxVersion"
        const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:$kotlinBomVersion"
    }

    object Compose {
        private const val activityComposeVersion = "1.7.2"
        private const val composeBomVersion = "2023.05.01"

        const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
        const val composeBom = "androidx.compose:compose-bom:$composeBomVersion"
        const val composeUi = "androidx.compose.ui:ui"
        const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val composeMaterial = "androidx.compose.material3:material3"
        const val composeUiTestJUnit = "androidx.compose.ui:ui-test-junit4"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling"
        const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    }

    object Test {
        private const val junitVersion = "4.13.2"
        private const val testExtJunitVersion = "1.1.5"
        private const val testEspressoVersion = "3.5.1"

        const val junit = "junit:junit:$junitVersion"
        const val testExtJunit = "androidx.test.ext:junit:$testExtJunitVersion"
        const val testEspresso = "androidx.test.espresso:espresso-core:$testEspressoVersion"
    }
}