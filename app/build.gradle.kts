plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.composenewsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.composenewsapp"
        minSdk = 24
        targetSdk = 34
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
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleKtx)
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.activityComposeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composematerial3)
    implementation(project(Module.utilities))
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.testJunit)
    androidTestImplementation(Dependencies.testEspresso)
    androidTestImplementation(platform(Dependencies.composeTestImp))
    androidTestImplementation(Dependencies.composeUiTest)
    debugImplementation(Dependencies.composeUiDebug)
    debugImplementation(Dependencies.debugComposeUi)



    // Dependency Injection
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.HiltCompiler)
    kapt(Dependencies.hiltAndroidCompiler)


    // Lifecycl
    implementation (Dependencies.lifeCycleViewModelCompose)
    implementation (Dependencies.lifeCycleViewModelKtx)
    implementation (Dependencies.lifeCycleRunTimeCompose)

    implementation(Dependencies.hiltNavigationCOmpose)

    //Retrofit
    implementation (Dependencies.retrofit2)
    implementation (Dependencies.okhttp)
    implementation (Dependencies.gsonConverter)
    implementation (Dependencies.moshi)
    implementation (Dependencies.moshiConverter)
    implementation (Dependencies.loggingIntercepter)

    //Coroutine
    implementation (Dependencies.coroutineAndroid)
    implementation (Dependencies.coroutineCore)
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("androidx.navigation:navigation-compose:2.5.1")
    implementation (Dependencies.splashScreen )
    implementation (Dependencies.coil )
    implementation (Dependencies.documentFile )

}

kapt{
    correctErrorTypes = true
}