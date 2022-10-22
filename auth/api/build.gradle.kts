plugins {
    kotlin("jvm")
}


dependencies {
    api(project(":data"))
    implementation(libs.kotlinx.coroutines)
}