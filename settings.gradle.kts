pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "groupeminaste"
includeBuild("convention-plugins")
include(":groupeminaste-commons")
include(":groupeminaste-backend")
