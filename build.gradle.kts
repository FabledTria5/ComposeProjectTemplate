plugins {
    id(Plugins.application) version Versions.gradle_version apply false
    id(Plugins.library) version Versions.gradle_version apply false
    id(Plugins.kotlinAndroid) version Versions.kotlin_gradle_version apply false
    id(Plugins.hilt) version Versions.hilt_android_version apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
}