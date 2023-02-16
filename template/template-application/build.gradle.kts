tasks.bootJar { enabled = false }
tasks.jar { enabled = true }

dependencies {
    implementation(project(":template:template-common"))
    implementation(project(":template:template-domain"))
}
