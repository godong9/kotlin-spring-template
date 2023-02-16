pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "kotlin-spring-template"

include(":template:template-common")
include(":template:template-domain")
include(":template:template-application")
include(":template:template-adapter")
include(":template:template-api")
// include(":template:template-batch")
