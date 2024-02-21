object Dependencies {

    //implementation("com.google.android.material:material:1.11.0")
    val material by lazy { "com.google.android.material:material:${Versions.material}" }

    //implementation("androidx.appcompat:appcompat:1.6.1")
    val appCompactKtx by lazy { "androidx.appcompat:appcompat:${Versions.appCompactKtx}" }

    //implementation("androidx.core:core-ktx:1.9.0")
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }

    //implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    val lifecycleKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}" }

    //implementation("androidx.activity:activity-compose:1.8.2")
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }

    //implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    val activityComposeBom by lazy { "androidx.compose:compose-bom:${Versions.activityComposeBom}" }

    //implementation("androidx.compose.ui:ui")
    val composeUi by lazy { "androidx.compose.ui:ui" }

    //implementation("androidx.compose.ui:ui-graphics")
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }

    //implementation("androidx.compose.ui:ui-tooling-preview")
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling-preview" }

    //implementation("androidx.compose.material3:material3")
    val composematerial3 by lazy { "androidx.compose.material3:material3" }

    //testImplementation("junit:junit:4.13.2")
    val junit by lazy { "junit:junit:${Versions.junit}" }

    //androidTestImplementation("androidx.test.ext:junit:1.1.5")
    val testJunit by lazy { "androidx.test.ext:junit:${Versions.testJunit}" }

    //    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    val testEspresso by lazy { "androidx.test.espresso:espresso-core:${Versions.testEspresso}" }

    //androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    val composeTestImp by lazy { "androidx.compose:compose-bom:${Versions.composeTestImp}" }

    //androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    val composeUiTest by lazy { "androidx.compose.ui:ui-test-junit4" }

    //    debugImplementation("androidx.compose.ui:ui-tooling")
    val composeUiDebug by lazy { "androidx.compose.ui:ui-tooling" }


    //debugImplementation("androidx.compose.ui:ui-test-manifest")
    val debugComposeUi by lazy { "androidx.compose.ui:ui-test-manifest" }


    // Dependency Injection
    val daggerHilt by lazy { "com.google.dagger:hilt-android:${Versions.daggerHilt}" }
    val HiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}" }
    val hiltAndroidCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }


    //    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:$${Versions.lifecycle_version}"
    val lifeCycleViewModelCompose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle_version}" }

    //    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$${Versions.lifecycle_version}"
    val lifeCycleViewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}" }

    //    implementation "androidx.lifecycle:lifecycle-runtime-compose:$${Versions.lifecycle_version}"
    val lifeCycleRunTimeCompose by lazy { "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycle_version}" }

    val hiltNavigationCOmpose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCOmpose}" }

//    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    val retrofit2 by lazy { "com.squareup.retrofit2:retrofit:2.9.0" }

//    implementation "com.squareup.okhttp3:okhttp:5.0.0-alpha.2"
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:5.0.0-alpha.2" }

//    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:2.9.0" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:1.13.0" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:2.9.0" }
    val loggingIntercepter by lazy { "com.squareup.okhttp3:logging-interceptor:4.8.1" }

    //implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    val coroutineAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineAndroid}" }

    //implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    val coroutineCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineAndroid}" }

    //implementation("io.coil-kt:coil-compose:2.5.0")
    val coil by lazy { "io.coil-kt:coil-compose:2.5.0" }



    val splashScreen by lazy { "androidx.core:core-splashscreen:1.0.1" }

    val documentFile by lazy { "androidx.documentfile:documentfile:1.0.1" }



}

object Module {
    const val utilities = ":utilities"
}