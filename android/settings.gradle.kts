// This is not a production application and as such we can use
// unstable/alpha/etc.. dependencies and whatnot.
// This allows us to play with the latest/greatest stuff 😁
@file:Suppress("UnstableApiUsage")

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

rootProject.name = "BizzyPlanets"

include(":app")