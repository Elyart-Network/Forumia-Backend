plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}


dependencies {
    api("org.jetbrains.kotlinx:kotlinx-serialization-core:1.4.0")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    api("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.4.0")
}