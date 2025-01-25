plugins {
    id("java-library")
    alias(libs.plugins.kotlinX.serialization)
//    alias(libs.plugins.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
/*kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}*/

dependencies {
    api(libs.bundles.ktor)
    implementation(libs.koin.core)
    implementation(libs.napier)
}
