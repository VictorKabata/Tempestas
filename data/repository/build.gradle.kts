plugins {
    id("java-library")
//    alias(libs.plugins.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
/*
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}
*/

dependencies {
    implementation(project(":domain"))
    api(project(":data:network"))
    api(project(":data:cache"))
}
