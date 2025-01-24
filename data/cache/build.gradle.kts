plugins {
    id("java-library")
    // alias(libs.plugins.kotlin.jvm)
//    alias(libs.plugins.ksp)
//    alias(libs.plugins.room)
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

/*room {
    schemaDirectory("$projectDir/schemas")
}*/

dependencies {
//    implementation(libs.room.runtime)
//    implementation(libs.sqlite.bundled)

//    add("kspAndroid", libs.room.compiler)
//    add("kspIosX64", libs.room.compiler)
//    add("kspIosArm64", libs.room.compiler)
//    add("kspIosSimulatorArm64", libs.room.compiler)
//    add("kspDesktop", libs.room.compiler)
}
