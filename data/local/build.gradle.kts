plugins {
    id(Plugins.library)
    kotlin(Plugins.android)
    kotlin(Plugins.kapt)
    id(Plugins.ksp) version Versions.ksp_version
    id(Plugins.hilt)
}

android {
    namespace = "dev.fabled.local"
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
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTargetVersion
    }
}

dependencies {

    // Core
    implementation(dependencyNotation = Dependencies.kotlinCoreKtx)

    // Room
    implementation(dependencyNotation = Dependencies.roomRuntime)
    implementation(dependencyNotation = Dependencies.roomKtx)
    implementation(dependencyNotation = Dependencies.roomPaging)
    ksp(dependencyNotation = Dependencies.roomCompiler)

    // Dagger Hilt
    implementation(dependencyNotation = Dependencies.hiltAndroid)
    implementation(dependencyNotation = Dependencies.hiltCompose)
    kapt(dependencyNotation = Dependencies.hiltCompiler)

    // Tests
    testApi(dependencyNotation = Dependencies.junit)
    androidTestApi(dependencyNotation = Dependencies.androidJunit)
}