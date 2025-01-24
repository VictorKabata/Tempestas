plugins {
    id("java-library")
//    alias(libs.plugins.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
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
