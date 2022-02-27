pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "clean-architecture-kotlin-spring"

include(":template-common")
include(":template-domain")
include(":template-application")
include(":template-adapter")
include(":template-api")
// include(":template-batch")
