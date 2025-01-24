plugins {
    id("java-library")
    // alias(libs.plugins.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

/*kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11
    }
}*/

dependencies {
    api(libs.koin.core)
    api(libs.napier)
    api(libs.coroutines)
}
