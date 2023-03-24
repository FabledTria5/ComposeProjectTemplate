plugins {
    id(Plugins.library)
    kotlin(Plugins.android)
    kotlin(Plugins.kapt)
    id(Plugins.hilt)
}

android {
    namespace = "dev.fabled.common"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = Config.testRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isRenderscriptDebuggable = false
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.composeCompilerExtensionVersion
    }
}

dependencies {

    implementation(project(":domain"))

    // Core
    implementation(dependencyNotation = Dependencies.kotlinCoreKtx)
    api(dependencyNotation = Dependencies.lifecycleRuntime)
    api(dependencyNotation = Dependencies.appcompat)
    api(dependencyNotation = Dependencies.timber)

    // Compose
    api(dependencyNotation = Dependencies.activityCompose)
    api(dependencyNotation = Dependencies.composeUi)
    api(dependencyNotation = Dependencies.composeMaterial)
    api(dependencyNotation = Dependencies.extendedIcons)
    api(dependencyNotation = Dependencies.coil)

    // Compose Preview
    api(dependencyNotation = Dependencies.composeToolingPreview)
    debugApi(dependencyNotation = Dependencies.composeTooling)
    debugApi(dependencyNotation = Dependencies.customview)
    debugApi(dependencyNotation = Dependencies.poolingContainer)

    // Dagger Hilt
    implementation(dependencyNotation = Dependencies.hiltAndroid)
    implementation(dependencyNotation = Dependencies.hiltCompose)
    kapt(dependencyNotation = Dependencies.hiltCompiler)
}