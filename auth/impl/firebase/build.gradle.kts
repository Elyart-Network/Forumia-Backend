plugins {
    kotlin("jvm")
}


dependencies {
    api(project(":auth:api"))
    implementation(libs.kotlinx.coroutines)
    implementation(libs.firebase.admin)
}