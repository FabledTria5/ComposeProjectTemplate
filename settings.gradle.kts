pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "ComposeProjectTemplate"
include(":app")
include(":common")
include(":navigation")
include(":data")
include(":data:remote")
include(":data:local")
include(":data:repository")
include(":domain")
include(":features")
