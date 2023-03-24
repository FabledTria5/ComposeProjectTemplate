plugins {
    id(Plugins.library)
    id(Plugins.hilt)
    kotlin(Plugins.android)
    kotlin(Plugins.kapt)
    kotlin(Plugins.serialization) version Versions.kotlin_gradle_version
}

android {
    namespace = "dev.fabled.remote"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = Config.testRunner
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTargetVersion
    }
}

dependencies {

    // Kotlin
    implementation(dependencyNotation = Dependencies.kotlinCoreKtx)
    implementation(dependencyNotation = Dependencies.kotlinSerialization)

    // Dagger Hilt
    implementation(dependencyNotation = Dependencies.hiltAndroid)
    implementation(dependencyNotation = Dependencies.hiltCompose)
    kapt(dependencyNotation = Dependencies.hiltCompiler)

    // Network
    implementation(dependencyNotation = Dependencies.retrofit)
    implementation(dependencyNotation = Dependencies.kotlinSerializationConverter)
    implementation(dependencyNotation = Dependencies.loggingInterceptor)
//    implementation(dependencyNotation = Dependencies.jsoup)

    // Tests
    testApi(dependencyNotation = Dependencies.junit)
    androidTestApi(dependencyNotation = Dependencies.androidJunit)
}