import org.gradle.api.JavaVersion

object Config {
    const val compileSdk = 33
    const val minSdk = 26
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"

    const val applicationId = "dev.fabled.composeprojecttemplate" // TODO: Set actual applicationId
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val jvmTargetVersion = "17"
    const val composeCompilerExtensionVersion = "1.4.4"

    val javaVersion = JavaVersion.VERSION_17
}