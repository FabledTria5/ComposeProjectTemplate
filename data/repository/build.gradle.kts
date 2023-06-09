plugins {
    id(Plugins.library)
    kotlin(Plugins.android)
    kotlin(Plugins.kapt)
    id(Plugins.hilt)
}

android {
    namespace = "dev.fabled.repository"
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

    implementation(project(":data:local"))
    implementation(project(":data:remote"))
    implementation(project(":domain"))

    // Core
    implementation(dependencyNotation = Dependencies.kotlinCoreKtx)
    coreLibraryDesugaring(dependencyNotation = Dependencies.desugar)
    implementation(dependencyNotation = Dependencies.timber)

    // Firebase
    // api(dependencyNotation = Dependencies.firebaseAuth)
    // api(dependencyNotation = Dependencies.fireStore)
    // implementation(dependencyNotation = Dependencies.googleAuthentication)
    // implementation(dependencyNotation = Dependencies.firebaseCoroutines)

    // Dagger Hilt
    implementation(dependencyNotation = Dependencies.hiltAndroid)
    implementation(dependencyNotation = Dependencies.hiltCompose)
    kapt(dependencyNotation = Dependencies.hiltCompiler)

    // Preferences
    // implementation(dependencyNotation = Dependencies.preferencesDatastore)

    // Tests
    testImplementation(dependencyNotation = Dependencies.junit)
    androidTestImplementation(dependencyNotation = Dependencies.androidJunit)
}