pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "df-plugin-demo"

// include the generated folder as a dependency in the project
includeBuild("genApisGuru") {
    dependencySubstitution {
        substitute(
            module("guru.apis:apis-guru")
        ).using(
            project(":")
        )
    }
}
