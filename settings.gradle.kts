pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "kotlin-spring-template"

include(":template-common")
include(":template-domain")
include(":template-application")
include(":template-adapter")
include(":template-api")
// include(":template-batch")
