plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    /*id("com.google.firebase.appdistribution")
    id("com.google.gms.google-services")*/
}

android {
    namespace = "com.vickbt.tempestas"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.vickbt.tempestas"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(":shared"))

    // Koin-Dependency injection
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    implementation(libs.core.ktx)
    implementation(libs.material3)

    implementation(libs.lifecycle.runtime)

    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)

    // implementation(libs.firebase.analytics)

    testImplementation(libs.androidX.junit)
    testImplementation(libs.android.test.core)
    testImplementation(libs.kotlinX.coroutines.test)
    testImplementation(libs.mockk)
    testImplementation(libs.google.truth)
    testImplementation(libs.roboelectric)

    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.mockk.android)

    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}
